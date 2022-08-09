package com.java.organization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.organization.model.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, Integer> {

}
