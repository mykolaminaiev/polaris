package com.polaris.aws.service;

import com.polaris.aws.model.SecurityGroupInfo;
import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.AwsZone;

import java.util.Collection;
import java.util.Map;

/**
 * Work with Aws Security groups
 * Created by Serhii_Nosko on 2016.
 */
public interface AwsSecurityService {

    /**
     * Describe security groups
     *
     * @param account the aws account
     * @param zone    the aws zone
     * @return the security groups (groupId, group)
     */
    Map<String, SecurityGroupInfo> describeSecurityGroups(AwsAccount account, AwsZone zone);

    /**
     * Describe security groups by ids
     *
     * @param groupIds the group ids
     * @param account  the aws account
     * @param zone     the aws zone
     * @return the security groups (groupId, group)
     */
    Map<String, SecurityGroupInfo> describeSecurityGroups(Collection<String> groupIds, AwsAccount account, AwsZone zone);
}
