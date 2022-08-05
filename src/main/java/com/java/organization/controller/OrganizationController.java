package com.java.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.organization.dto.OrganizationRequest;
import com.java.organization.dto.RestResponse;
import com.java.organization.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	public OrganizationService organizationService;

	@PostMapping(path = "/create")
	public ResponseEntity<String> createOrganization(@RequestBody OrganizationRequest organizationRequest) {

		
		String message = organizationService.createOrganization(organizationRequest);

		if (message.contains("successfully"))
			return ResponseEntity.status(201).body(message);
		else
			return ResponseEntity.status(400).body(message);
	}

	@GetMapping(path = "/findall")
	public ResponseEntity<RestResponse> findAllOrganization() {
		return organizationService.findAllOrganizations();
	}

	@GetMapping(path = "/find/{orgId}")
	public ResponseEntity<RestResponse> findAllOrganization(@PathVariable(name = "orgId") int organizationId) {
		return organizationService.findOrganizationById(organizationId);
	}

	@PutMapping(path = "/update/{organizationId}")
	public ResponseEntity<RestResponse> updateOrganizationDetail(@PathVariable(name = "organizationId") int organizationId,
			@RequestBody OrganizationRequest organizationRequest) {
		return organizationService.updateOrganizationDetailById(organizationId, organizationRequest);
	}
}
