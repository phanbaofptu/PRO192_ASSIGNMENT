package pro_assignment_7.Modules;

import java.util.*;
import pro_assignment_7.Employee;

public class PRO_Assignment_7 {
    private static final String CSVPATH = "input.csv";    
    private static final ArrayList<Employee> list = new ArrayList<Employee>();
    
    public static void main(String[] args) {
        String[] options = {
            "Doc du lieu tu file csv",
            "Tinh tien va cap nhat thong tin",
            "Hien thi danh sach",
            "Quit"
        };
        int choice;
        
        do {
            System.out.println("\nChuong trinh quan li nhan vien");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1: InputModule.input(list, CSVPATH); break;
                case 2: UpdateModule.update(list); break;
                case 3: ViewModule.view(list); break;
                default: System.out.println("Closing...");
            }
        }
        while (choice > 0 && choice < options.length);
    }
}
