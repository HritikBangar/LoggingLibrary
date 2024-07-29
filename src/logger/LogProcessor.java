package logger;

import dto.LogLevel;
import dto.LogMessage;
import dto.TimeFormat;
import formatter.LogFormattingService;
import sink.LogSink;

public abstract class LogProcessor {

    LogProcessor nextLogProcessor;
    LogSink logSink;
    LogLevel loggingLevel;
    TimeFormat timeFormat;

    public void log(LogMessage message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(message);
        }
    }

    public LogProcessor(LogProcessor nextLogProcessor, LogSink logSink, LogLevel loggingLevel, TimeFormat timeFormat) {
        this.nextLogProcessor = nextLogProcessor;
        this.logSink = logSink;
        this.loggingLevel = loggingLevel;
        this.timeFormat = timeFormat;
    }

    void write(LogMessage message) {
        logSink.write(formatMessage(message));
    }

    String formatMessage(LogMessage message) {
        return LogFormattingService.format(timeFormat, message);
    }
}
