package pro_assignment_7;

import java.util.Date;

public class Dev extends Employee {
    private int doneTaskNumber;                         
    private int allowance;
    
    public Dev() {
        super();
    }
    
    public Dev(String empId, String account, int role, Date workStartingDate, float productivityScore, int doneTaskNumber) {
        super(empId, account, role, workStartingDate, productivityScore);
        this.doneTaskNumber = doneTaskNumber;
    }
    
    @Override
    public int calMonthlyIncome() {
        return (doneTaskNumber * 1500000) + super.getRewardSalary() + allowance;
    }
    

    public int getDoneTaskNumber() {
        return doneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        this.doneTaskNumber = doneTaskNumber;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-25s %5d    %-20s %5s     %-15s %10d",
                "Task da hoan thanh:", doneTaskNumber, "", "", "Thu nhap hang thang:", super.getMonthlyIncome());
    }
}
