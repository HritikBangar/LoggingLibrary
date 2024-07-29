package formatter;

import dto.LogMessage;

public interface LogFormatter {
    public String format(LogMessage message);
}
