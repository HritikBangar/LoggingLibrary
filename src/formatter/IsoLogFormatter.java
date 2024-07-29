package formatter;

import dto.LogMessage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class IsoLogFormatter implements LogFormatter {
    @Override
    public String format(LogMessage message) {
        Instant instant = Instant.ofEpochMilli(message.getTimestamp());
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDate = dateTime.format(formatter);
        return String.format("%s [%s] [%s] %s", message.getLevel().getLevelName(), formattedDate, message.getNamespace(), message.getContent());
    }
}
