package com.java.organization.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.java.organization.dto.OrganizationRequest;
import com.java.organization.dto.RestResponse;
import com.java.organization.model.Organization;
import com.java.organization.repository.OrganizationRepository;

@Component
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	public String createOrganization(OrganizationRequest organizationRequest) {

		if (organizationRequest != null) {

			if (organizationRequest.getOrganizationId() > 0) {

				Organization organization = new Organization(organizationRequest.getOrganizationId(),
						organizationRequest.getName(), organizationRequest.getTotalEmployees(), organizationRequest.getLocation(),
						organizationRequest.getZip());

				organizationRepository.save(organization); //database;
				return "Organization created successfully";
			} else 
				return "Invalid Organization Id";
		} else {
			return "Invalid Request";
		}
	}

	public ResponseEntity<RestResponse> findAllOrganizations() {

		List<Organization> organizations = organizationRepository.findAll();
		if (organizations.size() > 0)
			return ResponseEntity.status(200).body(new RestResponse(200, null, organizations.size()+" organization(s) were fetched successfully.", organizations)) ;
		else
			return ResponseEntity.status(200).body(new RestResponse(200, "no organization found", null, null));
	}

	public ResponseEntity<RestResponse> findOrganizationById(int organizationId) {
		
		if (organizationId > 0) {

			Optional<Organization> organizationFound = organizationRepository.findById(organizationId);
			if (organizationFound.isPresent())
				return ResponseEntity.status(200).body(new RestResponse(200, null, "1 organization found.", organizationFound.get()));
			else
				return ResponseEntity.status(404).body(new RestResponse(404, null, "No organization found.", null)) ;
		} else {
			return ResponseEntity.status(400).body(new RestResponse(400, "Please add organization id", null, null));
		}
	}

	public ResponseEntity<RestResponse> updateOrganizationDetailById(int organizationId, OrganizationRequest organizationRequest) {

		if (organizationId > 0 && organizationRequest != null) {

			Optional<Organization> organization = organizationRepository.findById(organizationId); //organization
			
			if (organization.isPresent()) {
	
				if (organizationRequest.getName() != null) {
					organization.get().setName(organizationRequest.getName());
				}

				if (organizationRequest.getLocation() != null) {
					organization.get().setLocation(organizationRequest.getLocation());
				}
				
				if (organizationRequest.getTotalEmployees() > 0) {
					organization.get().setTotalEmployees(organizationRequest.getTotalEmployees());
				}

				if (organizationRequest.getZip() > 0) {
					organization.get().setZip(organizationRequest.getZip());
				}

				organizationRepository.save(organization.get());
				return ResponseEntity.status(200).body(new RestResponse(200, null, "1 organization updated successfully.", organization));
			} else {
				return ResponseEntity.status(404).body(new RestResponse(404, "No organization for Id "+organizationId+" found.", null, null));
			}
		} else
			return ResponseEntity.status(400).body(new RestResponse(400, "Please provide organization id and request", null, null));
	}

	public ResponseEntity<RestResponse> deleteOrganizationById(int organizationId) {

		if (organizationId > 0) {

			organizationRepository.deleteById(organizationId);
			return ResponseEntity.status(200).body(new RestResponse(200, null, "1 organization deleted successfully.", null));

		} else {
			return ResponseEntity.status(400).body(new RestResponse(400, "Please provide organization id.", null, null));
		}
	}
}
