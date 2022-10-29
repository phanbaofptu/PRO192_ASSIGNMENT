/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Date;

/**
 *
 * @author phangiabao
 */
public class Management extends Employee{
    int resolveIssueNumber;
    int otherTaskNumber;
    double allowance;

    public Management(String empId, String account, String role, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary) {
        super(empId, account, role, workStartingDate, productivityScore);
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getWorkStartingDate() {
        return workStartingDate;
    }

    public void setWorkStartingDate(Date workStartingDate) {
        this.workStartingDate = workStartingDate;
    }

    public double getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(double productivityScore) {
        this.productivityScore = productivityScore;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getRewardSalary() {
        return rewardSalary;
    }

    public void setRewardSalary(double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }
    
    

    @Override
    public double calMonthlyIncome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
