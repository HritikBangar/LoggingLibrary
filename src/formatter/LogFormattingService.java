package formatter;

import dto.LogMessage;
import dto.TimeFormat;

import java.util.HashMap;
import java.util.Map;

public class LogFormattingService {

    private static final Map<TimeFormat, LogFormatter> formatters = new HashMap<TimeFormat, LogFormatter>() {{
        put(TimeFormat.ISO, new IsoLogFormatter());
        put(TimeFormat.TIMESTAMP, new TimestampLogFormatter());
    }};

    public static String format(TimeFormat timeFormat, LogMessage message) {
        if (formatters.containsKey(timeFormat)) {
            return formatters.get(timeFormat).format(message);
        }
        return "";
    }
}
