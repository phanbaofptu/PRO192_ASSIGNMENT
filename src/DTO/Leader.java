/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.text.SimpleDateFormat;
import static java.util.Calendar.DATE;
import tool.DateDif;

/**
 *
 * @author phangiabao
 */
public class Leader extends Employee{
    int reviewTaskNumber;
    int supportTaskNumber;
    double allowance;

    public Leader(String empId, String account, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary) {
        super(empId, account, "LEADER", workStartingDate, productivityScore);
        this.reviewTaskNumber = reviewTaskNumber;
        this.supportTaskNumber = supportTaskNumber;
    }

    public int getReviewTaskNumber() {
        return reviewTaskNumber;
    }

    public void setReviewTaskNumber(int reviewTaskNumber) {
        this.reviewTaskNumber = reviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return supportTaskNumber;
    }

    public void setSupportTaskNumber(int supportTaskNumber) {
        this.supportTaskNumber = supportTaskNumber;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }


    

    @Override
    public double calMonthlyIncome() {
calReward();
        calAllowance();
        setMonthlyIncome((double)(reviewTaskNumber * 4000000) + (double)(supportTaskNumber* 400000) + getRewardSalary() + getAllowance());
        return getMonthlyIncome();    }

    @Override
    public double calAllowance() {
 if(DateDif.getMonthDiff(getWorkStartingDate(), new Date()) >= 36)
            this.allowance = (long)(2000000 * getProductivityScore());
        else this.allowance = (long) (1200000 * getProductivityScore());
        return this.allowance;    }

    @Override
    public String toString() {
return getRole() + "," + getEmpId() + "," + getAccount() + "," + new SimpleDateFormat("dd/MM/yyyy").format(getWorkStartingDate()) + "," + 
				getProductivityScore() + "," + getReviewTaskNumber() + "," + getSupportTaskNumber() +", "+ getMonthlyIncome() +", "+this.allowance;    }


    
    
}
