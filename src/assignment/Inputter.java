package assignment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    public static double inputDouble(String msg, double min, double max) {
        if (min > max) {
            double t = min;
            min = max;
            max = t;
        }
        double data;
        do {
            System.out.println(msg);
            data = Double.parseDouble(sc.nextLine());
        } while (data < min || data > max);
        return data;
    }

    public static String inputStr(String msg) {
        System.out.println(msg);
        String data = sc.nextLine().trim();
        return data;
    }

    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    public static String inputPatern(String msg, String pattern) {
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }
    private static boolean checkDate(String s){
        try {
            Date tmp = new SimpleDateFormat("dd/MM/yyyy").parse(s);
            return tmp.before(new Date());
        } catch (ParseException ex) {
           
        }
        return false;
    }
    public static Date inputDate(String msg) {
        String data = null;
        do {
            System.out.println(msg);
            data = sc.nextLine();
            
        } while(!checkDate(data));
        
        Date tmp = null;
        try {
            tmp = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Inputter.class.getName()).log(Level.SEVERE, null, ex);
        }
return tmp;
    }
}
