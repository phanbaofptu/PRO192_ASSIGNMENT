package GUI;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

    }

    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.println("choose 1.." + options.length + ":");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());

    }
}
