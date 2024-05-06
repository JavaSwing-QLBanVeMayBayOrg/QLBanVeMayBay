package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJcalendarUtil {
    public static String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        }
        return null;
    }
}
