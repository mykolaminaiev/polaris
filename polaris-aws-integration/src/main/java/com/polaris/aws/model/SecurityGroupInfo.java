package com.polaris.aws.model;

import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
public class SecurityGroupInfo {

    private String groupId;

    private List<IpPermission> inboundPermissions;

    private List<IpPermission> outboundPermissions;

    public SecurityGroupInfo(String groupId, List<IpPermission> inboundPermissions, List<IpPermission> outboundPermissions) {
        this.groupId = groupId;
        this.inboundPermissions = inboundPermissions;
        this.outboundPermissions = outboundPermissions;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<IpPermission> getInboundPermissions() {
        return inboundPermissions;
    }

    public List<IpPermission> getOutboundPermissions() {
        return outboundPermissions;
    }
}
