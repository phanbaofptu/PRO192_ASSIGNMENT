/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 * @author admin
 */
public class DateDif {
    public static int getMonthDiff(Date startDate, Date endDate) {
        LocalDate endLDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate strLDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period p = Period.between(strLDate, endLDate);
        return p.getMonths();
    }
}
