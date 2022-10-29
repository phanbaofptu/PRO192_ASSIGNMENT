package assignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author phangiabao
 */
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

    public static Date inputDate(String msg) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = new Date();
        df.format(date1);
        df.format(date2);
        do {

            df.setLenient(false);
            try {
                System.out.println(msg);
                date1 = df.parse(sc.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date");
            }
        } while (date1.before(date2));
        return date1;
    }
}
