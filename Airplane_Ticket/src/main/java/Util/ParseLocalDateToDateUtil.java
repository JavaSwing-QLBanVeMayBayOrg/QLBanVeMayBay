package Util;
import java.time.LocalDate;
import java.util.Date;
public class ParseLocalDateToDateUtil {
    public static Date convertToDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }
}
