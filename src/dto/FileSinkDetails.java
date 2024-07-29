package dto;

public class FileSinkDetails implements LoggerSinkDetail{
    private String fileName;
    private String fileLocation;
    private long sizeThreshold;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public FileSinkDetails(String fileName, String fileLocation, long sizeThreshold) {
        this.fileName = fileName;
        this.fileLocation = fileLocation;
        this.sizeThreshold = sizeThreshold;
    }

    public long getSizeThreshold() {
        return sizeThreshold;
    }

    public void setSizeThreshold(long sizeThreshold) {
        this.sizeThreshold = sizeThreshold;
    }
}
