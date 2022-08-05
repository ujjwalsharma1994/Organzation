package com.java.organization.dto;

public class OrganizationRequest {

	private int organizationId;
	private String name;
	private int totalEmployees;
	private String location;
	private int zip;

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "OrganizationRequest [oragnizationId=" + organizationId + ", name=" + name + ", totalEmployees="
				+ totalEmployees + ", location=" + location + ", zip=" + zip + "]";
	}
}
