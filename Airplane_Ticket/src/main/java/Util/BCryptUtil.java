package Util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
