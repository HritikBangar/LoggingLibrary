package logger;

import dto.LogLevel;
import dto.LoggerConfiguration;
import dto.TimeFormat;
import sink.LogSink;
import sink.LogSinkFactory;

import java.util.List;

public class LoggerProcessorFactory {
    private static volatile LogProcessor logProcessor;

    public static LogProcessor getLogProcessor(LoggerConfiguration loggerConfiguration) {
        if (logProcessor == null) {
            synchronized (LoggerProcessorFactory.class) {
                if (logProcessor == null) {
                    LogSink logSink = LogSinkFactory.getLogSink(loggerConfiguration.getLoggerSink(), loggerConfiguration.getSinkDetail());
                    LogLevel loggingLevel = loggerConfiguration.getLoggingLevel();
                    List<LogLevel> priorityWiseLoggerLevels = List.of(
                            LogLevel.FATAL,
                            LogLevel.ERROR,
                            LogLevel.WARN,
                            LogLevel.INFO,
                            LogLevel.DEBUG
                    );
                    LogProcessor currentLogProcessor = null;
                    for(LogLevel loggerLevel : priorityWiseLoggerLevels) {
                        currentLogProcessor = getLogProcessor(currentLogProcessor, logSink, loggingLevel, loggerLevel, loggerConfiguration.getTimeformat());
                    }
                    logProcessor = currentLogProcessor;
                    return logProcessor;
                }
            }
        }
        return logProcessor;
    }

    private static LogProcessor getLogProcessor(LogProcessor logProcessor, LogSink logSink, LogLevel loggingLevel, LogLevel loggerLevel, TimeFormat timeFormat) {
        return switch (loggerLevel) {
            case DEBUG -> new DebugLogProcessor(logProcessor, logSink, loggingLevel, timeFormat);
            case INFO -> new InfoLogProcessor(logProcessor, logSink, loggingLevel, timeFormat);
            case WARN -> new WarnLogProcessor(logProcessor, logSink, loggingLevel, timeFormat);
            case ERROR -> new ErrorLogProcessor(logProcessor, logSink, loggingLevel, timeFormat);
            case FATAL -> new FatalLogProcessor(logProcessor, logSink, loggingLevel, timeFormat);
        };
    }
}
