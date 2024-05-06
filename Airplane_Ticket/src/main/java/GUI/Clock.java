/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Clock extends Thread{
    private JLabel label;
    
    public Clock(JLabel label) {
        this.label = label;
    }
    
    public void run() {
        while (true) {
            Calendar ca = new GregorianCalendar();
            int mon=ca.get(Calendar.DAY_OF_WEEK);
            int day = ca.get(Calendar.DAY_OF_MONTH);
            int month = ca.get(Calendar.MONTH) + 1;
            int year = ca.get(Calendar.YEAR);
            int hour = ca.get(Calendar.HOUR);
            int minute = ca.get(Calendar.MINUTE);
            int second = ca.get(Calendar.SECOND);
            int PM_AM = ca.get(Calendar.AM_PM);
            
            String day_night = PM_AM == 1 ? "PM" : "AM";
            String DayOfWeek="";
//            switch(mon){
//                case 1: DayOfWeek="Chủ nhật";break;
//                case 2: DayOfWeek="Thứ 2";break;
//                case 3: DayOfWeek="Thứ 3";break;
//                case 4: DayOfWeek="Thứ 4";break;
//                case 5: DayOfWeek="Thứ 5";break;
//                case 6: DayOfWeek="Thứ 6";break;
//                case 7: DayOfWeek="Thứ 7";break;
//            }
            label.setText(day + "/" + month + "/" + year + " - " + hour + ":" + minute + ":" + second + " " + day_night);
        }
    }
}
