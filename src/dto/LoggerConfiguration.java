package dto;

public class LoggerConfiguration {
    private TimeFormat timeformat;
    private LogLevel loggingLevel;
    private LoggerSink loggerSink;
    private LoggerSinkDetail sinkDetail;

    public TimeFormat getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(TimeFormat timeformat) {
        this.timeformat = timeformat;
    }

    public LogLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LogLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public LoggerSink getLoggerSink() {
        return loggerSink;
    }

    public void setLoggerSink(LoggerSink loggerSink) {
        this.loggerSink = loggerSink;
    }

    public LoggerSinkDetail getSinkDetail() {
        return sinkDetail;
    }

    public void setSinkDetail(LoggerSinkDetail sinkDetail) {
        this.sinkDetail = sinkDetail;
    }
}
