/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JuuzouYT
 */
public class CompareTime {
    
    public boolean Difference(String start_date, String end_date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse(start_date);
            Date date2 = sdf.parse(end_date);
            long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
            long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
            long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
            if (differenceInHours > 0 || differenceInMinutes >= 15) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
