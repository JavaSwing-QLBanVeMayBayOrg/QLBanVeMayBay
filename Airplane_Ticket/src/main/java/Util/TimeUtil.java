package Util;

public class TimeUtil {

    public static String convertToFullTime(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        StringBuilder fullTime = new StringBuilder();

        if (hours > 0) {
            fullTime.append(hours).append(" giờ ");
        }
        if (minutes > 0) {
            fullTime.append(minutes).append(" phút ");
        }
        fullTime.append(seconds).append(" giây");

        return fullTime.toString();
    }
}
