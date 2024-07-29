package sink;

import dto.LoggerSink;
import dto.LoggerSinkDetail;

public class LogSinkFactory {
    public static LogSink getLogSink(LoggerSink loggerSink, LoggerSinkDetail loggerSinkDetail) {
        return switch (loggerSink) {
            case FILE -> new FileSink(loggerSinkDetail);
            case CONSOLE -> new ConsoleSink(loggerSinkDetail);
            default -> null;
        };
    }
}
