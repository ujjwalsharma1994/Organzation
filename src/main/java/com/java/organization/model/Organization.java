package com.java.organization.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organization")
public class Organization {

	@Id
	private int oragnizationId;
	private String name;
	private int totalEmployees;
	private String location;
	private int zip;

	public Organization(int oragnizationId, String name, int totalEmployees, String location, int zip) {
		super();
		this.oragnizationId = oragnizationId;
		this.name = name;
		this.totalEmployees = totalEmployees;
		this.location = location;
		this.zip = zip;
	}

	public int getOragnizationId() {
		return oragnizationId;
	}

	public void setOragnizationId(int oragnizationId) {
		this.oragnizationId = oragnizationId;
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
		return "Organization [oragnizationId=" + oragnizationId + ", name=" + name + ", totalEmployees="
				+ totalEmployees + ", location=" + location + ", zip=" + zip + "]";
	}
}
