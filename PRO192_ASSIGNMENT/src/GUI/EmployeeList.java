package GUI;

import DTO.Dev;
import DTO.Employee;
import tool.Inputter;
import DTO.Leader;
import DTO.Management;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeList extends ArrayList<Employee> {

    public static Iterable<Employee> getArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void addEmployee(String line) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String newCode, newAccount, newRole;
    double newProductivityScore;
    int newResolveIssueNumber, newOtherTaskNumber, newReviewTaskNumber, newSupportTaskNumber, newDoneTaskNumber;
    Date newWorkStartingDate;
    boolean codeDuplicated = false;

    public EmployeeList() {
        super();
    }

    public Employee search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEmpId().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    public void searchEmployee() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed!");
        } else {
            String sCode = Inputter.inputStr("Input Employee ID for search: ");
            Employee emp = this.search(sCode);
            if (emp == null) {
                System.out.println("Employee " + sCode + " doesn't existed!");
            } else {
                System.out.println("Found: " + emp);
            }
        }
    }

    private boolean isCodeDuplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addEmployee() {

        do {
            newCode = Inputter.inputPatern("Employee ID MNVxxx: ", "[Mm][Nn][Vv][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode);
            if (codeDuplicated) {
                System.out.println("Code is duplicated!");
            }
        } while (codeDuplicated == true);
        newAccount = Inputter.inputNonBlankStr("Employee Account: ");
        newAccount = newAccount.toUpperCase();

        newRole = Inputter.inputNonBlankStr("Employee Role (Management, Leader, Dev): ");
        newRole = newRole.toUpperCase();

        newWorkStartingDate = Inputter.inputDate("Work Starting Date: ");

        newProductivityScore = Inputter.inputDouble("Productivity Score (0.8-1.2): ", 0.8, 1.2);

        Employee emp = null;
        if (newRole.equalsIgnoreCase("MANAGEMENT")) {
            newResolveIssueNumber = Inputter.inputInt("Resolve Issue Number: ");
            newOtherTaskNumber = Inputter.inputInt("Other Task Number: ");
            emp = new Management(newCode, newAccount, newWorkStartingDate, newProductivityScore, newResolveIssueNumber, newOtherTaskNumber);
        } else if (newRole.equalsIgnoreCase("LEADER")) {
            newReviewTaskNumber = Inputter.inputInt("Review Task Number: ");
            newSupportTaskNumber = Inputter.inputInt("Support Task Number: ");
            emp = new Leader(newCode, newAccount, newWorkStartingDate, newProductivityScore, newReviewTaskNumber, newSupportTaskNumber);
        } else if (newRole.equalsIgnoreCase("DEV")) {
            newDoneTaskNumber = Inputter.inputInt("Done Task Number: ");
            emp = new Dev(newCode, newAccount, newWorkStartingDate, newProductivityScore, newDoneTaskNumber, newProductivityScore);
        }
        this.add(emp);
        System.out.println("Employee " + newCode + " has been added");
    }

    public void updateEmployee() {
        String upAccount, upRole;
        double upProductivityScore;
        Date upWorkStartingDate;
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uCode = Inputter.inputStr("Input Employee ID for update: ");
            Employee emp = this.search(uCode);
            if (emp == null) {
                System.out.println("Employee " + uCode + " doesn't existed!");
            } else {
                String oldAcount = emp.getAccount();
                String msg = "Old Account: " + oldAcount + " ,New Account: ";
                upAccount = Inputter.inputNonBlankStr(msg);
                emp.setAccount(upAccount);
                upAccount = upAccount.toUpperCase();

                String oldRole = emp.getRole();
                String msg2 = "Old Role: " + oldRole + " ,New Role: ";
                upRole = Inputter.inputNonBlankStr(msg2);
                emp.setRole(upRole);
                upRole = upRole.toUpperCase();

                double oldProductivityScore = emp.getProductivityScore();
                String msg3 = "Old ProductivityScore: " + oldProductivityScore + " ,New ProductivityScore: ";
                upProductivityScore = Inputter.inputDouble(msg3, 0.8, 1.2);
                emp.setProductivityScore(upProductivityScore);

                Date oldWorkStartingDate = emp.getWorkStartingDate();
                String msg4 = "Old Work Starting Date: " + oldWorkStartingDate + " ,New WorkStartingDate: ";
                upWorkStartingDate = Inputter.inputDate(msg4);
                emp.setWorkStartingDate(upWorkStartingDate);

                System.out.println("Employee " + uCode + " has been updated!");
            }
        }

    }

    public void removeEmployee() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No remove can be performed!");
        } else {
            String rCode = Inputter.inputStr("Input Employee ID for  remove: ");
            Employee emp = this.search(rCode);
            if (emp == null) {
                System.out.println("Employee " + rCode + " doesn't existed!");
            } else {
                this.remove(emp);
                System.out.println("Employee " + rCode + " has been removed!");
            }
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Employee list:");
            for (Employee emp : this) {
                System.out.println(emp);
            }
            System.out.println("Total: " + this.size() + " employee(s).");
        }
    }
}
