package logger;

import dto.LogLevel;
import dto.LogMessage;
import dto.TimeFormat;
import sink.LogSink;

public class DebugLogProcessor extends LogProcessor {

    private final LogLevel loggerLevel = LogLevel.DEBUG;

    public DebugLogProcessor(LogProcessor nextLogProcessor, LogSink logSink, LogLevel loggingLevel, TimeFormat timeFormat) {
        super(nextLogProcessor, logSink, loggingLevel, timeFormat);
    }

    @Override
    public void log(LogMessage message) {
        if (message.getLevel().equals(loggerLevel) && loggerLevel.getSeverity() >= loggingLevel.getSeverity()) {
            write(message);
        } else {
            super.log(message);
        }
    }

    @Override
    void write(LogMessage message) {
        System.out.println(formatMessage(message));
        super.write(message);
    }
}
