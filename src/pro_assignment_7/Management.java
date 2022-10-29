package pro_assignment_7;

import java.util.*;

public class Management extends Employee {
    private int resolveIssueNumber;
    private int otherTaskNumber;
    private int allowance;
    
    public Management() {
        super();
    }
    
    public Management(String empId, String account, int role, Date workStartingDate, float productivityScore, int resolveIssueNumber, int otherTaskNumber) {
        super(empId, account, role, workStartingDate, productivityScore);
        this.resolveIssueNumber = resolveIssueNumber;
        this.otherTaskNumber = otherTaskNumber;
    }
    
    //interface default method ?
    public int calAllowance() {
        Date now = new Date();
        int workMonth = (int) (now.getMonth() - super.getWorkStartingDate().getMonth());
        if (workMonth < 36)
            return (int)(1200000 * super.getProductivityScore());
        return (int)(2000000 * super.getProductivityScore());
    }
    
    @Override
    public int calMonthlyIncome() {
        return (resolveIssueNumber * 5000000) + (otherTaskNumber * 500000) + super.getRewardSalary() + allowance;
    }

    
    
    
    
    
    
    
    public int getResolveIssueNumber() {
        return resolveIssueNumber;
    }

    public int getOtherTaskNumber() {
        return otherTaskNumber;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setResolveIssueNumber(int resolveIssueNumber) {
        this.resolveIssueNumber = resolveIssueNumber;
    }

    public void setOtherTaskNumber(int otherTaskNumber) {
        this.otherTaskNumber = otherTaskNumber;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-25s %5d    %-20s %5d     %-15s %10d",
                "Van de da giai quyet:", resolveIssueNumber,  "Task common:", otherTaskNumber, "Thu nhap hang thang:", super.getMonthlyIncome());
    }
}
