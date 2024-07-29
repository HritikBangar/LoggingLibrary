package logger;

import dto.LogLevel;
import dto.LogMessage;
import dto.TimeFormat;
import sink.LogSink;

public class InfoLogProcessor extends LogProcessor {

    private final LogLevel loggerLevel = LogLevel.INFO;

    public InfoLogProcessor(LogProcessor nextLogProcessor, LogSink logSink, LogLevel loggingLevel, TimeFormat timeFormat) {
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
