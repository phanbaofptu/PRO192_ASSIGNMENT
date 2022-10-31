/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Collections;

/**
 *
 * @author phangiabao
 */
public class EmployeeManager {
    public static void main(String[] args) {
        String [] options = {
        "Add new employee",
        "Search a employee", 
        "Update the information of employee", 
        "Remove a employee", 
        "Sort ascending by MonthlyIncome and descending by Account", 
        "Sort ascending by Empld and Role", 
        "Display" , 
        "Quit"};
        int choice = 0 ;
        EmployeeList list = new EmployeeList();
        do{
        System.out.println("Employee managing Program");
        choice = Menu.getChoice(options);
        switch(choice){
            case 1: list.addEmployee();
               break;
            case 2: list.searchEmployee();
               break;
            case 3: list.updateEmployee();
               break;
            case 4: list.removeEmployee();
               break;
            case 5: Collections.sort(list, new MonthAccountComparator());
               break;
            case 6: Collections.sort(list, new RoleEmpidComparator());
               break;
            case 7: list.printAll();
               break;
            default: System.out.println("Good bye!!!");
                }
        }
        while (choice > 0 && choice < 8);
    }
    
}
