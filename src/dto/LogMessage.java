package dto;

public class LogMessage {
    private final String content;
    private final LogLevel level;
    private final String namespace;
    private final String traceId;
    private final long timestamp;

    LogMessage(LogMessageBuilder builder) {
        this.content = builder.getContent();
        this.level = builder.getLevel();
        this.namespace = builder.getNamespace();
        this.traceId = builder.getTraceId();
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getTraceId() {
        return traceId;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "content=" + content +
                ", level=" + level +
                ", namespace='" + namespace + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
