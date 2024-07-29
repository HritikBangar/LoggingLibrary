package dto;

public class LogMessageBuilder {
    private String content;
    private LogLevel level;
    private String namespace;
    private String traceId;

    public LogMessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public LogMessageBuilder setLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    public LogMessageBuilder setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public LogMessageBuilder setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public LogMessage build() {
        return new LogMessage(this);
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
}
