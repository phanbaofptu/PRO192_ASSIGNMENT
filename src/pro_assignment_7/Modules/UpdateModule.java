package pro_assignment_7.Modules;
import pro_assignment_7.*;

import java.util.*;

public class UpdateModule {
    public static void update(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id:");
        Employee target = searchEmployee(list, sc.nextLine());
        updateEmployee(target);
    }
    
    static Employee searchEmployee(ArrayList<Employee> list, String targetId) {
        for (Employee emp : list)
            if (emp.getEmpId().equals(targetId))
                return emp;
        return list.get(0);
    }
    
    static void updateEmployee(Employee target) {
        target.setRewardSalary(target.getRewardSalary());
        
        if (target instanceof Management management)
            management.setAllowance(management.calAllowance());
        else if (target instanceof Leader leader)
            leader.setAllowance(leader.calAllowance());
        
        target.setMonthlyIncome(target.calMonthlyIncome());
    }
}
