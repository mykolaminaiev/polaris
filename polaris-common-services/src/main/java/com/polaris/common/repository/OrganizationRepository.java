package com.polaris.common.repository;

import com.polaris.persistence.entity.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mykola_Minaiev
 */
public interface OrganizationRepository extends MongoRepository<Organization, String> {
    Organization findByName(String name);
}
