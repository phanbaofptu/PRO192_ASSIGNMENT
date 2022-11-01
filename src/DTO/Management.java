package DTO;


import DTO.Employee;
import java.util.Date;

public class Management extends Employee {

	private int resolveIssueNumber;
	private int otherTaskNumber;
	private double allowance;

	@Override
	public long calMonthlyIncome() {
		return (long) ((this.resolveIssueNumber * 5000000) + (this.otherTaskNumber * 500000) + this.getRewardSalary()
				+ this.getAllowance());
	}

	public long calAllowance() {
		Date currentDate = new Date();
		int numberMonthWork = (int) ((currentDate.getTime() - this.getWorkStartingDate().getTime()) / 3600);
		if (numberMonthWork >= 36) {
			return (long) this.getProductivityScore() * 2000000;
		} else {
			return (long) this.getProductivityScore() * 1200000;
		}
	}

	public Management() {
		super();
	}

	public Management(String empId, int role, String account, Date workStartingDate, double productivityScore,
			int resolveIssueNumber, int otherTaskNumber) {
		super(empId, role, account, workStartingDate, productivityScore);
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
	public String toString() {
		return "Management ["+ super.toString()+", ResolveIssueNumber: " + resolveIssueNumber + ", Other Task Number: " + otherTaskNumber
				+ ", Allowance: " + allowance + "]\n" ;
	}

}
