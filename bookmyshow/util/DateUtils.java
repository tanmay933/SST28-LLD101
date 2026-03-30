package bookmyshow.util;

import java.time.Instant;

public class DateUtils {

    public static long now() {
        return Instant.now().toEpochMilli();
    }
}