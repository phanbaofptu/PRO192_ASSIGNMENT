/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author phangiabao
 */
public class Dev extends Employee {

    int doneTaskNumber;

    public Dev(String empId, String account, Date workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary) {
        super(empId, account, "DEV", workStartingDate, productivityScore);
    }

    public int getDoneTaskNumber() {
        return doneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        this.doneTaskNumber = doneTaskNumber;
    }

    @Override
    public double calMonthlyIncome() {
        calReward();
        setMonthlyIncome((double)(getDoneTaskNumber() * 1500000) + getRewardSalary());
        return this.getMonthlyIncome();
    }
    @Override
	public double calAllowance() {
		return 0;
	}

    @Override
	public String toString() {
		return getRole() + "," + getEmpId() + "," + getAccount() + "," + new SimpleDateFormat("dd/MM/yyyy").format(getWorkStartingDate()) + "," + 
				getProductivityScore() + "," + getDoneTaskNumber();
	}
        
}
