package dto;

public enum LogLevel {
    DEBUG(1, "DEBUG"),
    INFO(2, "INFO"),
    WARN(3, "WARN"),
    ERROR(4, "ERROR"),
    FATAL(5, "FATAL");

    private final int severity;
    private final String levelName;

    LogLevel(int severity, String levelName) {
        this.severity = severity;
        this.levelName = levelName;
    }

    public int getSeverity() {
        return severity;
    }
    public String getLevelName() {
        return levelName;
    }
}
