package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String convertMillisToDate(Long expiresAt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(expiresAt);

        return simpleDateFormat.format(date);
    }

    public static Long convertDateToMillis(String expires_at) {
        return 0L;
    }
}
