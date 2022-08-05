package com.java.organization.repository;

import java.util.ArrayList;
import java.util.List;

import com.java.organization.model.Organization;

public class OrganizationRepository {

	private static List<Organization> organizations = new ArrayList<>();

	static {
		organizations.add(new Organization(1, "Infosys", 20000, "Jammu", 180004));
		organizations.add(new Organization(2, "TCS", 30000, "Jammu", 180004));
		organizations.add(new Organization(4, "Wipro", 20000, "Jammu", 180004));
		organizations.add(new Organization(3, "Tech Mahindra", 20000, "Jammu", 180004));
		organizations.add(new Organization(5, "Accenture", 20000, "Jammu", 180004));
	}
	
	public static Organization save(Organization organization) {
		organizations.add(organization);
		return organization;
	}

	public static List<Organization> fetchAll() {
		return organizations;
	}

	public static Organization findOrganizationById(int organizationId) {

		return organizations.stream()
				.filter(e -> e.getOragnizationId() == organizationId)
				.findFirst()
				.orElse(null);
	}

	public static Organization updateOrganizationObject(Organization oldOrganizationObject, Organization latestOrganizationObject) {

		return organizations.set(organizations
				.indexOf(organizations.stream()
						.filter(e ->e.getOragnizationId() == oldOrganizationObject.getOragnizationId())
						.findFirst()
						.orElse(null)), latestOrganizationObject);
	}
}
