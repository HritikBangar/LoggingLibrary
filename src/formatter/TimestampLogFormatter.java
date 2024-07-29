package formatter;

import dto.LogMessage;
import dto.TimeFormat;

public class TimestampLogFormatter implements LogFormatter {

    public String format(LogMessage message) {
        long timestamp = message.getTimestamp();
        return String.format("%s [%s] [%s] %s", message.getLevel().getLevelName(), timestamp, message.getNamespace(), message.getContent());
    }
}
