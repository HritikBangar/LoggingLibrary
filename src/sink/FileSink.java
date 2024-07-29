package sink;

import dto.FileSinkDetails;
import dto.LoggerSinkDetail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileSink implements LogSink {

    FileSinkDetails fileSinkDetails;
    private final Lock lock;
    private final Path filePath;

    @Override
    public void write(String message) {
        lock.lock();
        try {
            if (Files.size(filePath) > fileSinkDetails.getSizeThreshold()) {
                rotateLogFile();
            }
            Files.write(filePath, (message + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public FileSink(LoggerSinkDetail sinkDetail) {
        this.fileSinkDetails = (FileSinkDetails) sinkDetail;
        this.filePath = Paths.get(String.format("%s/%s", fileSinkDetails.getFileLocation(), fileSinkDetails.getFileName()));
        this.lock = new ReentrantLock();
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creating log file: " + e.getMessage());
        }
    }

    private void rotateLogFile() throws IOException {
        String archiveFileName = filePath.toString().replace(".log", "_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".zip");
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(Paths.get(archiveFileName), StandardOpenOption.CREATE))) {
            zos.putNextEntry(new ZipEntry(filePath.getFileName().toString()));
            Files.copy(filePath, zos);
            zos.closeEntry();
        }
        Files.write(filePath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
    }
}
