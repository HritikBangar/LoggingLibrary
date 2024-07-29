package sink;


import dto.LoggerSinkDetail;

public class ConsoleSink implements LogSink {

    LoggerSinkDetail loggerSinkDetail;

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    public ConsoleSink(LoggerSinkDetail loggerSinkDetail) {
        this.loggerSinkDetail = loggerSinkDetail;
    }
}
