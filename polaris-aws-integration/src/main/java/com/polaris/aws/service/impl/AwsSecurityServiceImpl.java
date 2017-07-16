package com.polaris.aws.service.impl;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.polaris.aws.model.IpPermission;
import com.polaris.aws.model.SecurityGroupInfo;
import com.polaris.aws.service.AwsClientsFactory;
import com.polaris.aws.service.AwsSecurityService;
import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.AwsZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Service
public class AwsSecurityServiceImpl implements AwsSecurityService {

    @Autowired
    private AwsClientsFactory awsClientsFactory;

    @Override
    public Map<String, SecurityGroupInfo> describeSecurityGroups(AwsAccount account, AwsZone zone) {
        AmazonEC2 client = awsClientsFactory.getEC2Client(account.getAccessKey(), account.getSecretKey(), zone.getEndpoint());

        DescribeSecurityGroupsResult describeResults = client.describeSecurityGroups();
        List<SecurityGroup> securityGroups = describeResults.getSecurityGroups();

        return convertSecurityGroups(securityGroups);
    }

    @Override
    public Map<String, SecurityGroupInfo> describeSecurityGroups(Collection<String> groupIds, AwsAccount account, AwsZone zone) {
        AmazonEC2 client = awsClientsFactory.getEC2Client(account.getAccessKey(), account.getSecretKey(), zone.getEndpoint());

        // get from aws
        DescribeSecurityGroupsResult describeResults = client.describeSecurityGroups();
        List<SecurityGroup> securityGroups = describeResults.getSecurityGroups();

        // filter
        filterSecurityGroups(groupIds, securityGroups);

        //convert
        return convertSecurityGroups(securityGroups);
    }

    private void filterSecurityGroups(Collection<String> groupIds, List<SecurityGroup> securityGroups) {
        Iterator<SecurityGroup> iterator = securityGroups.iterator();
        while (!iterator.hasNext()) {
            SecurityGroup group = iterator.next();
            if (!groupIds.contains(group.getGroupId())) {
                iterator.remove();
            }
        }
    }

    private IpPermission createIpPermission(com.amazonaws.services.ec2.model.IpPermission permission) {
        return new IpPermission(permission.getIpProtocol(),
                permission.getFromPort(),
                permission.getToPort(),
                permission.getIpRanges());
    }

    private Map<String, SecurityGroupInfo> convertSecurityGroups(List<SecurityGroup> securityGroups) {
        Map<String, SecurityGroupInfo> result = new HashMap<>();

        for (SecurityGroup group : securityGroups) {
            List<IpPermission> inboundIpPermissions = new ArrayList<>();
            List<IpPermission> outboundIpPermissions = new ArrayList<>();

            group.getIpPermissions().forEach(ipPermission -> inboundIpPermissions.add(createIpPermission(ipPermission)));
            group.getIpPermissionsEgress().forEach(ipPermission -> outboundIpPermissions.add(createIpPermission(ipPermission)));

            SecurityGroupInfo info = new SecurityGroupInfo(group.getGroupId(), inboundIpPermissions, outboundIpPermissions);
            result.put(info.getGroupId(), info);
        }

        return result;
    }
}
