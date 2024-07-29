import dto.*;
import logger.LogProcessor;
import logger.LoggerProcessorFactory;

public class Main {
    public static void main(String[] args) {

        LoggerConfiguration loggerConfiguration = new LoggerConfiguration();
        loggerConfiguration.setLoggerSink(LoggerSink.FILE);
        loggerConfiguration.setLoggingLevel(LogLevel.DEBUG);
        loggerConfiguration.setTimeformat(TimeFormat.ISO);
        LoggerSinkDetail sinkDetail = new FileSinkDetails("application.log", "/Users/hritik/IdeaProjects/LoggingLibrary/logs", 200);
        loggerConfiguration.setSinkDetail(sinkDetail);


        LogProcessor logProcessor= LoggerProcessorFactory.getLogProcessor(loggerConfiguration);


        LogMessage message0 = new LogMessageBuilder().setContent("testing log 0").setLevel(LogLevel.FATAL).setNamespace("Payments").setTraceId("123").build();
        LogMessage message1 = new LogMessageBuilder().setContent("testing log 1").setLevel(LogLevel.INFO).setNamespace("Payments").setTraceId("123").build();
        LogMessage message2 = new LogMessageBuilder().setContent("testing log 2").setLevel(LogLevel.ERROR).setNamespace("Payments").setTraceId("123").build();
        LogMessage message3 = new LogMessageBuilder().setContent("testing log 3").setLevel(LogLevel.DEBUG).setNamespace("Payments").setTraceId("123").build();
        LogMessage message4 = new LogMessageBuilder().setContent("testing log 4").setLevel(LogLevel.WARN).setNamespace("Payments").setTraceId("123").build();

        logProcessor.log(message0);
        logProcessor.log(message1);
        logProcessor.log(message2);
        logProcessor.log(message3);
        logProcessor.log(message4);
    }
}
