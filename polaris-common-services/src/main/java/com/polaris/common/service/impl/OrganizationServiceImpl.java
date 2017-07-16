package com.polaris.common.service.impl;

import com.polaris.common.repository.OrganizationRepository;
import com.polaris.common.repository.UserRepository;
import com.polaris.common.service.OrganizationService;
import com.polaris.persistence.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mykola_Minaiev
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<Organization> listOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization findById(String id) {
        return organizationRepository.findOne(id);
    }

    @Override
    public Organization findByName(String name) {
        return organizationRepository.findByName(name);
    }

    @Override
    public Organization addNewOrganization(Organization organizationEntity) {
        return organizationRepository.insert(organizationEntity);
    }

    @Override
    public Organization changeOrganizationName(String id, String organizationName) {
        Organization organization = organizationRepository.findOne(id);
        organization.setName(organizationName);
        return organizationRepository.save(organization);
    }

    @Override
    public void deleteOrganization(String id) {
        organizationRepository.delete(id);
    }
}
