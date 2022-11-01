package DTO;

import java.util.Date;
import DTO.Employee;


public class Dev extends Employee {
	private int doneTaskNumber;

	@Override
	public long calMonthlyIncome() {
		return (long) (this.doneTaskNumber * 1500000 + this.getRewardSalary());
	}

	public Dev() {
		super();
	}

	public Dev(String empId, int role, String account, Date workStartingDate, double productivityScore, int doneTaskNumber) {
		super(empId, role, account,  workStartingDate, productivityScore);
		this.doneTaskNumber = doneTaskNumber;
	}

	public int getDoneTaskNumber() {
		return doneTaskNumber;
	}

	public void setDoneTaskNumber(int doneTaskNumber) {
		this.doneTaskNumber = doneTaskNumber;
	}

	@Override
	public String toString() {
		return "Dev [" + super.toString() + ", Done Task Number: " +doneTaskNumber + "] " +"\n" ;
	}
}