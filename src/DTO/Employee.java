package DTO;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {

	private String empId;
	private int role;
	private String account;
	private Date workStartingDate;
	private double productivityScore;
	private long monthlyIncome;
	private long rewardSalary;

	public Employee() {
		super();
	}

	public Employee(String empId, int role, String account, Date workStartingDate, double productivityScore) {
		super();
		this.empId = empId;
		this.role = role;
		this.account = account;
		this.workStartingDate = workStartingDate;
		this.productivityScore = productivityScore;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public double getRewardSalary() {
		return rewardSalary;
	}

	public void setRewardSalary(long rewardSalary) {
		this.rewardSalary = rewardSalary;
	}

	public abstract long calMonthlyIncome();

	public long calReward() {
		return (long)this.productivityScore * 3000000;
	}

	@Override
	public String toString() {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat formatter = new DecimalFormat("#0.0");
		return "Employee ID: " + empId + ", Role: " + role + ", Account: " + account + ", Work Starting Date: "
				+ df.format(workStartingDate) + ", Productivity Score: " + productivityScore + ", Monthly Income: " + formatter.format(monthlyIncome)
				+ ", Reward Salary:" + formatter.format(rewardSalary);
	}
}
