package com.polaris.common.service.impl;

import com.polaris.common.AbstractTestMongo;
import com.polaris.common.repository.OrganizationRepository;
import com.polaris.common.service.OrganizationService;
import com.polaris.persistence.entity.Organization;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mykola_Minaiev
 */
public class OrganizationServiceImplTest extends AbstractTestMongo {

    private static final String COLLECTION_NAME = "organization";

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationRepository organizationRepository;

    private List<Organization> testOrganizations = new ArrayList<>();
    private Organization testOrganizationOne;
    private Organization testOrganizationTwo;

    private Organization prepareOrganization(String id, String name) {
        Organization organization = new Organization();
        organization.setId(id);
        organization.setName(name);
        return organization;
    }

    @Before
    public void initOrganizations() {
        testOrganizationOne = prepareOrganization("1", "one");
        testOrganizationTwo = prepareOrganization("2", "two");
        testOrganizations.add(testOrganizationOne);
        testOrganizations.add(testOrganizationTwo);
        organizationRepository.save(testOrganizationOne);
        organizationRepository.save(testOrganizationTwo);
    }

    @After
    public void tearDown() {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

    @Test
    public void listOrganizations() throws Exception {
        List<Organization> organizations = (List<Organization>) organizationService.listOrganizations();
        assertEquals(testOrganizations.size(), organizations.size());
    }

    @Test
    public void findById() throws Exception {
        Organization organization = organizationService.findById("1");
        assertEquals(testOrganizationOne.getId(), organization.getId());
    }

    @Test
    public void findByName() throws Exception {
        Organization organization = organizationService.findByName("two");
        assertEquals(testOrganizationTwo.getId(), organization.getId());
    }

    @Test
    public void addNewOrganization() throws Exception {
        Organization organization = new Organization();
        organization.setId("3");
        organization.setName("three");
        organizationService.addNewOrganization(organization);
        assertEquals(3, organizationService.listOrganizations().spliterator().getExactSizeIfKnown());
    }

    @Test
    public void changeOrganizationName() throws Exception {
        Organization organization = organizationService.findByName("two");
        organizationService.changeOrganizationName(organization.getId(), "twoChanged");
        assertEquals("twoChanged", organizationService.findById(organization.getId()).getName());
    }

    @Test
    public void deleteOrganization() throws Exception {
        organizationService.deleteOrganization("1");
        assertEquals(1, organizationService.listOrganizations().spliterator().getExactSizeIfKnown());
    }
}