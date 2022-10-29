package pro_assignment_7;

import java.util.Date;

public class Leader extends Employee {
    private int reviewTaskNumber;
    private int supportTaskNumber;
    private int allowance;
    
    public Leader() {
        super();
    }
    
    public Leader(String empId, String account, int role, Date workStartingDate, float productivityScore, int reviewTaskNumber, int supportTaskNumber) {
        super(empId, account, role, workStartingDate, productivityScore);
        this.reviewTaskNumber = reviewTaskNumber;
        this.supportTaskNumber = supportTaskNumber;
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
        return (reviewTaskNumber * 4000000) + (supportTaskNumber * 400000) + super.getRewardSalary() + allowance;
    }
    
    public int getReviewTaskNumber() {
        return reviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return supportTaskNumber;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setReviewTaskNumber(int reviewTaskNumber) {
        this.reviewTaskNumber = reviewTaskNumber;
    }

    public void setSupportTaskNumber(int supportTaskNumber) {
        this.supportTaskNumber = supportTaskNumber;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-25s %5d    %-20s %5d     %-15s %10d",
                "Task da review:", reviewTaskNumber, "Task da support:", supportTaskNumber, "Thu nhap hang thang:", super.getMonthlyIncome());
    }
}
