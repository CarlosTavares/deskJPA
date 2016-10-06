/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Carlos.Tavares
 */
public class DateUtil {
    
    public static final String toString(Calendar cal) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String ret = formatter.format(cal.getTime());
        return ret;
    }
    
    public static final Calendar toCalendar(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
