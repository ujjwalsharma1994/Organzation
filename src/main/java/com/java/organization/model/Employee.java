package com.java.organization.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private int organizationId;
	private double salary;
	private String jobProfile;
	private boolean isManager;
	private String reportingManagerName;
	private String emailId;

	public Employee(int employeeId, String employeeName, int organizationId, double salary, String jobProfile,
			boolean isManager, String reportingManagerName, String emailId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.organizationId = organizationId;
		this.salary = salary;
		this.jobProfile = jobProfile;
		this.isManager = isManager;
		this.reportingManagerName = reportingManagerName;
		this.emailId = emailId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public String getReportingManagerName() {
		return reportingManagerName;
	}

	public void setReportingManagerName(String reportingManagerName) {
		this.reportingManagerName = reportingManagerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", organizationId="
				+ organizationId + ", salary=" + salary + ", jobProfile=" + jobProfile + ", isManager=" + isManager
				+ ", reportingManagerName=" + reportingManagerName + ", emailId=" + emailId + "]";
	}
}
