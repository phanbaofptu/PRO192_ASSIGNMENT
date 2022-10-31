package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author phangiabao
 */
public abstract class Employee {

    String empId;
    String account;
    String role;
    Date workStartingDate;
    double productivityScore;
    double monthlyIncome;
    double rewardSalary;

    public Employee(String empId, String account, String role, Date workStartingDate, double productivityScore) {
        this.empId = empId;
        this.account = account;
        this.role = role;
        this.workStartingDate = workStartingDate;
        this.productivityScore = productivityScore;
        this.monthlyIncome = monthlyIncome;
        this.rewardSalary = rewardSalary;
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
        account = account.trim().toUpperCase();
        if (account.length() > 0) {
            this.account = account;
        }
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
        if (productivityScore >= 0.8 && productivityScore <= 1.2) {
            this.productivityScore = productivityScore;
        }
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

    public abstract double calMonthlyIncome();

    public double calReward() {
        return productivityScore * 3000000;

    }
    public abstract double calAllowance();

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", account=" + account + ", role=" + role + ", workStartingDate=" + workStartingDate + ", productivityScore=" + productivityScore + ", monthlyIncome=" + monthlyIncome + ", rewardSalary=" + rewardSalary + '}';
    }
    
    

}
