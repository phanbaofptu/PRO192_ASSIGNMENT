/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Date;
import java.text.SimpleDateFormat;
import tool.DateDif;
/**
 *
 * @author phangiabao
 */
public class Management extends Employee{
    int resolveIssueNumber;
    int otherTaskNumber;
    double allowance;

    public Management(String empId, String account, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary) {
        super(empId, account, "MANAGEMENT", workStartingDate, productivityScore);
        this.resolveIssueNumber = resolveIssueNumber;
        this.otherTaskNumber = otherTaskNumber;
    }

    public int getResolveIssueNumber() {
        return resolveIssueNumber;
    }

    public void setResolveIssueNumber(int resolveIssueNumber) {
        this.resolveIssueNumber = resolveIssueNumber;
    }

    public int getOtherTaskNumber() {
        return otherTaskNumber;
    }

    public void setOtherTaskNumber(int otherTaskNumber) {
        this.otherTaskNumber = otherTaskNumber;
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
        setMonthlyIncome((double)(resolveIssueNumber * 5000000) + (long)(otherTaskNumber *500000) + getRewardSalary() + allowance);
        return getMonthlyIncome();    }

    @Override
    public double calAllowance() {
if(DateDif.getMonthDiff(getWorkStartingDate(), new Date()) >= 36)
            this.allowance = (long)(2000000 * getProductivityScore());
        else this.allowance = (long)(1200000 * getProductivityScore());
        return this.allowance;    }
    
    @Override
	public String toString() {
		return getRole() + "," + getEmpId() + "," + getAccount() + "," + new SimpleDateFormat("dd/MM/yyyy").format(getWorkStartingDate()) + "," + 
				getProductivityScore() + "," + getResolveIssueNumber() + "," + getOtherTaskNumber();
	}
}
