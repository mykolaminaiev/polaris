package com.polaris.ui.controller;

import com.polaris.common.service.OrganizationService;
import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.Organization;
import com.polaris.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Mykola_Minaiev
 */
@RestController
public class OrganizationsController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public Iterable<Organization> getOrganizations() {
        return organizationService.listOrganizations();
    }

    @RequestMapping(value = "/organizations/{id}", method = RequestMethod.GET)
    public Organization getOrganization(
            @PathVariable("id")
                    String id) {
        return organizationService.findById(id);
    }

    @RequestMapping(value = "/organizations/add/{name}", method = RequestMethod.PUT)
    public void addOrganization(
            @PathVariable("name")
                    String name, Principal principal) {
        User user = userService.findByName(principal.getName());
        Organization organization = new Organization();
        organization.setName(name);
        user.setOrganization(organizationService.addNewOrganization(organization));
        userService.updateUser(user);
    }

    @RequestMapping(value = "/organizations/{id}/changename/{name}", method = RequestMethod.POST)
    public void changeOrganizationName(
            @PathVariable("id")
                    String id,
            @PathVariable("name")
                    String organizationName) {
        organizationService.changeOrganizationName(id, organizationName);
    }

    @RequestMapping(value = "/organizations/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrganization(
            @PathVariable("id")
                    String id) {
        organizationService.deleteOrganization(id);
    }

}
