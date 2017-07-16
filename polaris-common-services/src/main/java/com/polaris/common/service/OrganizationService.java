package com.polaris.common.service;

import com.polaris.persistence.entity.Organization;

/**
 * @author Mykola_Minaiev
 */
public interface OrganizationService {

    Iterable<Organization> listOrganizations();

    Organization findById(String id);

    Organization findByName(String name);

    Organization addNewOrganization(Organization organizationEntity);

    Organization changeOrganizationName(String id, String organizationName);

    void deleteOrganization(String id);
}
