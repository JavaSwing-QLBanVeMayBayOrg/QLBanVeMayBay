package Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ParseMoneyUtil {
    public static String formatCurrency(BigDecimal amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");
        return formatter.format(amount) + " VND";
    }
}
