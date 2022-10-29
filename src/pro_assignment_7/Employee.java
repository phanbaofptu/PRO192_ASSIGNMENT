package pro_assignment_7;

import java.util.*;
import java.text.*;

public abstract class Employee {
    private String empId;
    private String account;
    private int role;
    private Date workStartingDate;
    private float productivityScore;
    private int monthlyIncome;
    private int rewardSalary;
    
    public Employee() {}
    
    public Employee(String empId, String account, int role, Date workStartingDate, float productivityScore) {
        this.empId = empId;
        this.account = account;
        this.role = role;
        this.workStartingDate = workStartingDate;
        this.productivityScore = productivityScore;
    }
    
    public abstract int calMonthlyIncome();
    
    public int calReward() {
        return (int)(productivityScore * 3000000);
    }

    
    
    
    
    
    public String getEmpId() {
        return empId;
    }

    public String getAccount() {
        return account;
    }

    public int getRole() {
        return role;
    }

    public Date getWorkStartingDate() {
        return workStartingDate;
    }

    public double getProductivityScore() {
        return productivityScore;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public int getRewardSalary() {
        return rewardSalary;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setWorkStartingDate(Date workStartingDate) {
        this.workStartingDate = workStartingDate;
    }

    public void setProductivityScore(float productivityScore) {
        this.productivityScore = productivityScore;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setRewardSalary(int rewardSalary) {
        this.rewardSalary = rewardSalary;
    }
    
    @Override
    public String toString() {
        String roleString = "";
        switch (role)
        {
            case 1: roleString = "Management"; break;
            case 2: roleString = "Leader"; break;
            case 3: roleString = "Dev"; break;
        }
        String formattedDate =  new SimpleDateFormat("dd/mm/yyyy").format(workStartingDate);
        return String.format("%-1s %-10s %-10s %15s     Hieu suat lam viec: %5.2f          ",
                roleString, empId, account, formattedDate, productivityScore);
    }
}
