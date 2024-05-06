package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatDate(String inputDate) {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        String outputDate = "";
        try {
            if (inputDate != null) {
                Date date = inputFormat.parse(inputDate);
                outputDate = outputFormat.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDate;
    }

    public static void main(String[] args) {
        String inputDate = "2024-05-03";
        String outputDate = formatDate(inputDate);
        System.out.println("Input Date: " + inputDate);
        System.out.println("Output Date: " + outputDate);
    }
}
