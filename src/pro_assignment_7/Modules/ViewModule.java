package pro_assignment_7.Modules;
import pro_assignment_7.*;

import java.util.*;

public class ViewModule {
    public static void view(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }
        byIncomeAndAccount(list);
        byRoleAndId(list);
    }
    
    static void byIncomeAndAccount(ArrayList<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                //sort by monthlyIncome in ascending order
                int compareIncome = e1.getMonthlyIncome() - e2.getMonthlyIncome();
                if (compareIncome != 0)
                    return compareIncome;
                //if equal, sort by account in descending order
                return e2.getAccount().compareTo(e1.getAccount());
            }
        });
        show(list);
    }
    
    static void byRoleAndId(ArrayList<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                //sort by role in ascending order
                int compareRole = e1.getRole() - e2.getRole();
                if (compareRole != 0)
                    return compareRole;
                //if equal, sort by empId in ascending order
                return e1.getEmpId().compareTo(e2.getEmpId());
            }
        });
        show(list);
    }
    
    static void show(ArrayList<Employee> list) {
        System.out.println("**********************************************Danh sach nhan vien**********************************************");
        for (Employee e: list) {
            System.out.println(e);
        }
    }
}
