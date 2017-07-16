package com.polaris.aws.model;

import java.util.ArrayList;
import java.util.List;

import static com.polaris.aws.model.StandardAwsService.*;

/**
 * Created by Serhii on 15.05.2016.
 */
public enum EventType {
    // Auto Scaling APIs
    ATTACH_INSTANCES(AUTO_SCALING, "AttachInstances"),
    COMPLETE_LIFECYCLE_ACTION(AUTO_SCALING, "CompleteLifecycleAction"),
    CREATE_AUTO_SCALING_GROUP(AUTO_SCALING, "CreateAutoScalingGroup"),
    CREATE_LAUNCH_CONFIGURATION(AUTO_SCALING, "CreateLaunchConfiguration"),
    CREATE_OR_UPDATE_TAGS(AUTO_SCALING, "CreateOrUpdateTags"),
    DELETE_AUTO_SCALING_GROUP(AUTO_SCALING, "DeleteAutoScalingGroup"),
    DELETE_LAUNCH_CONFIGURATION(AUTO_SCALING, "DeleteLaunchConfiguration"),
    DELETE_LIFECYCLE_HOOK(AUTO_SCALING, "DeleteLifecycleHook"),
    DELETE_NOTIFICATION_CONFIGURATION(AUTO_SCALING, "DeleteNotificationConfiguration"),
    DELETE_POLICY(AUTO_SCALING, "DeletePolicy"),
    DELETE_SCHEDULED_ACTION(AUTO_SCALING, "DeleteScheduledAction"),
    DELETE_TAGS_SCALING(AUTO_SCALING, "DeleteTags"),
    DETACH_INSTANCES(AUTO_SCALING, "DetachInstances"),
    DISABLE_METRICS_COLLECTION(AUTO_SCALING, "DisableMetricsCollection"),
    ENABLE_METRICS_COLLECTION(AUTO_SCALING, "EnableMetricsCollection"),
    ENTER_STANDBY(AUTO_SCALING, "EnterStandby"),
    EXECUTE_POLICY(AUTO_SCALING, "ExecutePolicy"),
    EXIT_STANDBY(AUTO_SCALING, "ExitStandby"),
    PUT_LIFECYCLE_HOOK(AUTO_SCALING, "PutLifecycleHook"),
    PUT_NOTIFICATION_CONFIGURATION(AUTO_SCALING, "PutNotificationConfiguration"),
    PUT_SCALING_POLICY(AUTO_SCALING, "PutScalingPolicy"),
    PUT_SCHEDULE_DUPDATE_GROUP_ACTION(AUTO_SCALING, "PutScheduledUpdateGroupAction"),
    RECORD_LIFECYCLE_ACTION_HEARTBEAT(AUTO_SCALING, "RecordLifecycleActionHeartbeat"),
    RESUME_PROCESSES(AUTO_SCALING, "ResumeProcesses"),
    SET_DESIRED_CAPACITY(AUTO_SCALING, "SetDesiredCapacity"),
    SET_INSTANCE_HEALTH(AUTO_SCALING, "SetInstanceHealth"),
    SUSPEND_PROCESSES(AUTO_SCALING, "SuspendProcesses"),
    TERMINATE_INSTANCE_IN_AUTO_SCALING_GROUP(AUTO_SCALING, "TerminateInstanceInAutoScalingGroup"),
    UPDATE_AUTO_SCALING_GROUP(AUTO_SCALING, "UpdateAutoScalingGroup"),

    // Aws Certificate Manager APIs
    DELETE_CERTIFICATE(AWS_CERTIFICATE_MANAGER, "DeleteCertificate"),
    REQUEST_CERTIFICATE(AWS_CERTIFICATE_MANAGER, "RequestCertificate"),
    RESEND_VALIDATION_EMAIL(AWS_CERTIFICATE_MANAGER, "ResendValidationEmail"),

    // Aws CloudFormation APIs
    CANCEL_UPDATE_STACK(AWS_CLOUD_FORMATION, "CancelUpdateStack"),
    CREATE_STACK(AWS_CLOUD_FORMATION, "CreateStack"),
    DELETE_STACK(AWS_CLOUD_FORMATION, "DeleteStack"),
    SET_STACK_POLICY(AWS_CLOUD_FORMATION, "SetStackPolicy"),
    SIGNAL_RESOURCE(AWS_CLOUD_FORMATION, "SignalResource"),
    UPDATE_STACK(AWS_CLOUD_FORMATION, "UpdateStack"),

    // Amazon CloudFront APIs
    CREATE_CLOUD_FRONT_ORIGIN_ACCESS_IDENTITY(AMAZON_CLOUD_FRONT, "CreateCloudFrontOriginAccessIdentity"),
    CREATE_DISTRIBUTION(AMAZON_CLOUD_FRONT, "CreateDistribution"),
    CREATE_INVALIDATION(AMAZON_CLOUD_FRONT, "CreateInvalidation"),
    CREATE_STREAMING_DISTRIBUTION(AMAZON_CLOUD_FRONT, "CreateStreamingDistribution"),
    DELETE_CLOUD_FRONT_ORIGIN_ACCESS_IDENTITY(AMAZON_CLOUD_FRONT, "DeleteCloudFrontOriginAccessIdentity"),
    DELETE_DISTRIBUTION(AMAZON_CLOUD_FRONT, "DeleteDistribution"),
    DELETE_STREAMING_DISTRIBUTION(AMAZON_CLOUD_FRONT, "DeleteStreamingDistribution"),
    UPDATE_CLOUD_FRONT_ORIGIN_ACCESS_IDENTITY(AMAZON_CLOUD_FRONT, "UpdateCloudFrontOriginAccessIdentity"),
    UPDATE_DISTRIBUTION(AMAZON_CLOUD_FRONT, "UpdateDistribution"),
    UPDATE_STREAMING_DISTRIBUTION(AMAZON_CLOUD_FRONT, "UpdateStreamingDistribution"),

    // AWS CloudHSM APIs
    ADMIN_CREATE_HSM(AWS_CLOUD_HSM, "AdminCreateHsm"),
    CREATE_HAPG(AWS_CLOUD_HSM, "CreateHapg"),
    CREATE_HSM(AWS_CLOUD_HSM, "CreateHsm"),
    CREATE_LUNA_CLIENT(AWS_CLOUD_HSM, "CreateLunaClient"),
    DELETE_HAPG(AWS_CLOUD_HSM, "DeleteHapg"),
    DELETE_HSM(AWS_CLOUD_HSM, "DeleteHsm"),
    DELETE_LUNA_CLIENT(AWS_CLOUD_HSM, "DeleteLunaClient"),
    MODIFY_HAPG(AWS_CLOUD_HSM, "ModifyHapg"),
    MODIFY_HSM(AWS_CLOUD_HSM, "ModifyHsm"),
    MODIFY_LUNA_CLIENT(AWS_CLOUD_HSM, "ModifyLunaClient"),

    // Amazon CloudSearch APIs
    BUILD_SUGGESTERS(AMAZON_CLOUD_SEARCH, "BuildSuggesters"),
    CREATE_DOMAIN(AMAZON_CLOUD_SEARCH, "CreateDomain"),
    DEFINE_ANALYSIS_SCHEME(AMAZON_CLOUD_SEARCH, "DefineAnalysisScheme"),
    DEFINE_EXPRESSION(AMAZON_CLOUD_SEARCH, "DefineExpression"),
    DEFINE_INDEX_FIE_LD(AMAZON_CLOUD_SEARCH, "DefineIndexField"),
    DEFINE_INDEX_FIE_LDS(AMAZON_CLOUD_SEARCH, "DefineIndexFields"),
    DEFINE_RANK_EXPRESSION(AMAZON_CLOUD_SEARCH, "DefineRankExpression"),
    DEFINE_SUGGESTER(AMAZON_CLOUD_SEARCH, "DefineSuggester"),
    DELETE_ANALYSIS_SCHEME(AMAZON_CLOUD_SEARCH, "DeleteAnalysisScheme"),
    DELETE_DOMAIN(AMAZON_CLOUD_SEARCH, "DeleteDomain"),
    DELETE_EXPRESSION(AMAZON_CLOUD_SEARCH, "DeleteExpression"),
    DELETE_INDEX_FIELD(AMAZON_CLOUD_SEARCH, "DeleteIndexField"),
    DELETE_RANK_EXPRESSION(AMAZON_CLOUD_SEARCH, "DeleteRankExpression"),
    DELETE_SUGGESTER(AMAZON_CLOUD_SEARCH, "DeleteSuggester"),
    INDEX_DOCUMENTS(AMAZON_CLOUD_SEARCH, "IndexDocuments"),
    UPDATE_AVAILABILITY_OPTIONS(AMAZON_CLOUD_SEARCH, "UpdateAvailabilityOptions"),
    UPDATE_DEFAULT_SEARCH_FIELD(AMAZON_CLOUD_SEARCH, "UpdateDefaultSearchField"),
    UPDATE_SCALING_PARAMETERS(AMAZON_CLOUD_SEARCH, "UpdateScalingParameters"),
    UPDATE_SERVICE_ACCESS_POLICIES(AMAZON_CLOUD_SEARCH, "UpdateServiceAccessPolicies"),
    UPDATE_STEMMING_OPTIONS(AMAZON_CLOUD_SEARCH, "UpdateStemmingOptions"),
    UPDATE_STOPWORD_OPTIONS(AMAZON_CLOUD_SEARCH, "UpdateStopwordOptions"),
    UPDATE_SYNONYM_OPTIONS(AMAZON_CLOUD_SEARCH, "UpdateSynonymOptions"),


    // Amazon EC2 APIs
    ACCEPT_VPC_PEERING_CONNECTION(AMAZON_EC2, "AcceptVpcPeeringConnection"),
    ALLOCATE_ADDRESS(AMAZON_EC2, "AllocateAddress"),
    ALLOCATE_HOSTS(AMAZON_EC2, "AllocateHosts"),
    ASSIGN_PRIVATE_IP_ADDRESSES(AMAZON_EC2, "AssignPrivateIpAddresses"),
    ASSOCIATE_ADDRESS(AMAZON_EC2, "AssociateAddress"),
    ASSOCIATE_DHCP_OPTIONS(AMAZON_EC2, "AssociateDhcpOptions"),
    ASSOCIATE_ROUTE_TABLE(AMAZON_EC2, "AssociateRouteTable"),
    ATTACH_CLASSIC_LINK_VPC(AMAZON_EC2, "AttachClassicLinkVpc"),
    ATTACH_INTERNET_GATEWAY(AMAZON_EC2, "AttachInternetGateway"),
    ATTACH_NETWORK_INTERFACE(AMAZON_EC2, "AttachNetworkInterface"),
    ATTACH_VOLUME(AMAZON_EC2, "AttachVolume"),
    ATTACH_VPN_GATEWAY(AMAZON_EC2, "AttachVpnGateway"),
    AUTHORIZE_SECURITY_GROUP_EGRESS(AMAZON_EC2, "AuthorizeSecurityGroupEgress"),
    AUTHORIZE_SECURITY_GROUP_INGRESS(AMAZON_EC2, "AuthorizeSecurityGroupIngress"),
    BUNDLE_INSTANCE(AMAZON_EC2, "BundleInstance"),
    CANCEL_BUNDLE_TASK(AMAZON_EC2, "CancelBundleTask"),
    CANCEL_CONVERSION_TASK(AMAZON_EC2, "CancelConversionTask"),
    CANCEL_EXPORT_TASK(AMAZON_EC2, "CancelExportTask"),
    CANCEL_IMPORT_TASK(AMAZON_EC2, "CancelImportTask"),
    CANCEL_RESERVED_INSTANCES_LISTING(AMAZON_EC2, "CancelReservedInstancesListing"),
    CANCEL_SPOT_INSTANCE_REQUESTS(AMAZON_EC2, "CancelSpotInstanceRequests"),
    COPY_IMAGE(AMAZON_EC2, "CopyImage"),
    COPY_SNAPSHOT(AMAZON_EC2, "CopySnapshot"),
    CREATE_CUSTOMER_GATEWAY(AMAZON_EC2, "CreateCustomerGateway"),
    CREATE_DHCP_OPTIONS(AMAZON_EC2, "CreateDhcpOptions"),
    CREATE_IMAGE(AMAZON_EC2, "CreateImage"),
    CREATE_INSTANCE_EXPORT_TASK(AMAZON_EC2, "CreateInstanceExportTask"),
    CREATE_INTERNET_GATEWAY(AMAZON_EC2, "CreateInternetGateway"),
    CREATE_KEYPAIR(AMAZON_EC2, "CreateKeyPair"),
    CREATE_NAT_GATEWAY(AMAZON_EC2, "CreateNatGateway"),
    CREATE_NETWORK_ACL(AMAZON_EC2, "CreateNetworkAcl"),
    CREATE_NETWORK_ACL_ENTRY(AMAZON_EC2, "CreateNetworkAclEntry"),
    CREATE_NETWORK_INTERFACE(AMAZON_EC2, "CreateNetworkInterface"),
    CREATE_PLACEMENT_GROUP(AMAZON_EC2, "CreatePlacementGroup"),
    CREATE_RESERVED_INSTANCE_SLISTING(AMAZON_EC2, "CreateReservedInstancesListing"),
    CREATE_ROUTE(AMAZON_EC2, "CreateRoute"),
    CREATE_ROUTE_TABLE(AMAZON_EC2, "CreateRouteTable"),
    CREATE_SNAPSHOT(AMAZON_EC2, "CreateSnapshot"),
    CREATE_SPOT_DATAFEED_SUBSCRIPTION(AMAZON_EC2, "CreateSpotDatafeedSubscription"),
    CREATE_SUBNET(AMAZON_EC2, "CreateSubnet"),
    CREATE_TAGS(AMAZON_EC2, "CreateTags"),
    CREATE_VOLUME(AMAZON_EC2, "CreateVolume"),
    CREATE_VPC(AMAZON_EC2, "CreateVpc"),
    CREATE_VPC_ENDPOINT(AMAZON_EC2, "CreateVpcEndpoint"),
    CREATE_VPC_PEERING_CONNECTION(AMAZON_EC2, "CreateVpcPeeringConnection"),
    CREATE_VPN_CONNECTION(AMAZON_EC2, "CreateVpnConnection"),
    CREATE_VPN_CONNECTION_ROUTE(AMAZON_EC2, "CreateVpnConnectionRoute"),
    CREATE_VPN_GATEWAY(AMAZON_EC2, "CreateVpnGateway"),
    DELETE_CUSTOMER_GATEWAY(AMAZON_EC2, "DeleteCustomerGateway"),
    DELETE_DHCP_OPTIONS(AMAZON_EC2, "DeleteDhcpOptions"),
    DELETE_INTERNET_GATEWAY(AMAZON_EC2, "DeleteInternetGateway"),
    DELETE_KEYPAIR(AMAZON_EC2, "DeleteKeyPair"),
    DELETE_NAT_GATEWAY(AMAZON_EC2, "DeleteNatGateway"),
    DELETE_NETWORK_ACL(AMAZON_EC2, "DeleteNetworkAcl"),
    DELETE_NETWORK_ACL_ENTRY(AMAZON_EC2, "DeleteNetworkAclEntry"),
    DELETE_NETWORK_INTERFACE(AMAZON_EC2, "DeleteNetworkInterface"),
    DELETE_PLACEMENT_GROUP(AMAZON_EC2, "DeletePlacementGroup"),
    DELETE_ROUTE(AMAZON_EC2, "DeleteRoute"),
    DELETE_ROUTE_TABLE(AMAZON_EC2, "DeleteRouteTable"),
    DELETE_SECURITY_GROUP(AMAZON_EC2, "DeleteSecurityGroup"),
    DELETE_SNAPSHOT(AMAZON_EC2, "DeleteSnapshot"),
    DELETE_SPOT_DATAFEED_SUBSCRIPTION(AMAZON_EC2, "DeleteSpotDatafeedSubscription"),
    DELETE_SUBNET(AMAZON_EC2, "DeleteSubnet"),
    DELETE_TAGS(AMAZON_EC2, "DeleteTags"),
    DELETE_VOLUME(AMAZON_EC2, "DeleteVolume"),
    DELETE_VPC(AMAZON_EC2, "DeleteVpc"),

    DELETE_VPC_ENDPOINTS(AMAZON_EC2, "DeleteVpcEndpoints"),
    DELETE_VPC_PEERING_CONNECTION(AMAZON_EC2, "DeleteVpcPeeringConnection"),
    DELETE_VPN_CONNECTION(AMAZON_EC2, "DeleteVpnConnection"),
    DELETE_VPN_CONNECTION_ROUTE(AMAZON_EC2, "DeleteVpnConnectionRoute"),
    DELETE_VPN_GATEWAY(AMAZON_EC2, "DeleteVpnGateway"),
    DEREGISTER_IMAGE(AMAZON_EC2, "DeregisterImage"),
    DETACH_CLASSIC_LINK_VPC(AMAZON_EC2, "DetachClassicLinkVpc"),
    DETACH_INTERNET_GATEWAY(AMAZON_EC2, "DetachInternetGateway"),
    DETACH_NETWORK_INTERFACE(AMAZON_EC2, "DetachNetworkInterface"),
    DETACH_VOLUME(AMAZON_EC2, "DetachVolume"),
    DETACH_VPN_GATEWAY(AMAZON_EC2, "DetachVpnGateway"),
    DISABLE_VGW_ROUTE_PROPAGATION(AMAZON_EC2, "DisableVgwRoutePropagation"),
    DISABLE_VPC_CLASSIC_LINK(AMAZON_EC2, "DisableVpcClassicLink"),
    DISASSOCIATE_ADDRESS(AMAZON_EC2, "DisassociateAddress"),
    DISASSOCIATE_ROUTE_TABLE(AMAZON_EC2, "DisassociateRouteTable"),
    ENABLE_VGW_ROUTE_PROPAGATION(AMAZON_EC2, "EnableVgwRoutePropagation"),
    ENABLE_VOLUME_IO(AMAZON_EC2, "EnableVolumeIO"),
    ENABLE_VPC_CLASSIC_LINK(AMAZON_EC2, "EnableVpcClassicLink"),
    IMPORT_IMAGE(AMAZON_EC2, "ImportImage"),
    IMPORT_INSTANCE(AMAZON_EC2, "ImportInstance"),

    IMPORT_KEY_PAIR(AMAZON_EC2, "ImportKeyPair"),
    IMPORT_SNAPSHOT(AMAZON_EC2, "ImportSnapshot"),
    IMPORT_VOLUME(AMAZON_EC2, "ImportVolume"),
    MODIFY_HOSTS(AMAZON_EC2, "ModifyHosts"),
    MODIFY_IMAGE_ATTRIBUTE(AMAZON_EC2, "ModifyImageAttribute"),
    MODIFY_INSTANCE_ATTRIBUTE(AMAZON_EC2, "ModifyInstanceAttribute"),
    MODIFY_INSTANCE_PLACEMENT(AMAZON_EC2, "ModifyInstancePlacement"),
    MODIFY_NETWORK_INTERFACE_ATTRIBUTE(AMAZON_EC2, "ModifyNetworkInterfaceAttribute"),
    MODIFY_RESERVED_INSTANCES(AMAZON_EC2, "ModifyReservedInstances"),
    MODIFY_SNAPSHOT_ATTRIBUTE(AMAZON_EC2, "ModifySnapshotAttribute"),
    MODIFY_SUBNET_ATTRIBUTE(AMAZON_EC2, "ModifySubnetAttribute"),
    MODIFY_VOLUME_ATTRIBUTE(AMAZON_EC2, "ModifyVolumeAttribute"),
    MODIFY_VPC_ATTRIBUTE(AMAZON_EC2, "ModifyVpcAttribute"),
    MODIFY_VPC_ENDPOINT(AMAZON_EC2, "ModifyVpcEndpoint"),
    MONITOR_INSTANCES(AMAZON_EC2, "MonitorInstances"),
    MOVE_ADDRESS_TO_VPC(AMAZON_EC2, "MoveAddressToVpc"),
    PURCHASE_RESERVED_INSTANCES_OFFERING(AMAZON_EC2, "PurchaseReservedInstancesOffering"),
    REBOOT_INSTANCES(AMAZON_EC2, "RebootInstances"),
    REGISTER_IMAGE(AMAZON_EC2, "RegisterImage"),
    REJECT_VPC_PEERING_CONNECTION(AMAZON_EC2, "RejectVpcPeeringConnection"),

    RELEASE_ADDRESS(AMAZON_EC2, "ReleaseAddress"),
    RELEASE_HOSTS(AMAZON_EC2, "ReleaseHosts"),
    REPLACE_NETWORK_ACL_ASSOCIATION(AMAZON_EC2, "ReplaceNetworkAclAssociation"),
    REPLACE_NETWORK_ACL_ENTRY(AMAZON_EC2, "ReplaceNetworkAclEntry"),
    REPLACE_ROUTE(AMAZON_EC2, "ReplaceRoute"),
    REPLACE_ROUTE_TABLE_ASSOCIATION(AMAZON_EC2, "ReplaceRouteTableAssociation"),
    REQUEST_SPOT_INSTANCES(AMAZON_EC2, "RequestSpotInstances"),
    RESET_IMAGE_ATTRIBUTE(AMAZON_EC2, "ResetImageAttribute"),
    RESET_INSTANCE_ATTRIBUTE(AMAZON_EC2, "ResetInstanceAttribute"),
    RESET_NETWORK_INTERFACE_ATTRIBUTE(AMAZON_EC2, "ResetNetworkInterfaceAttribute"),
    RESET_SNAPSHOT_ATTRIBUTE(AMAZON_EC2, "ResetSnapshotAttribute"),
    RESTORE_ADDRESS_TO_CLASSIC(AMAZON_EC2, "RestoreAddressToClassic"),
    REVOKE_SECURITY_GROUP_EGRESS(AMAZON_EC2, "RevokeSecurityGroupEgress"),
    REVOKE_SECURITY_GROUP_INGRESS(AMAZON_EC2, "RevokeSecurityGroupIngress"),
    RUN_INSTANCES(AMAZON_EC2, "RunInstances"),
    START_INSTANCES(AMAZON_EC2, "StartInstances"),
    STOP_INSTANCES(AMAZON_EC2, "StopInstances"),
    TERMINATE_INSTANCES(AMAZON_EC2, "TerminateInstances"),
    UNASSIGN_PRIVATE_IP_ADDRESSES(AMAZON_EC2, "UnassignPrivateIpAddresses"),
    UNMONITOR_INSTANCES(AMAZON_EC2, "UnmonitorInstances");

    private static final EventType[] values = values();

    private StandardAwsService service;

    private String eventName;

    EventType(StandardAwsService service, String eventName) {
        this.service = service;
        this.eventName = eventName;
    }

    public static EventType[] getValues() {
        return values;
    }

    public static boolean isInTypes(String eventName) {
        for (EventType type : getValues()) {
            if (type.getEventName().equalsIgnoreCase(eventName)) {
                return true;
            }
        }
        return false;
    }

    public static List<EventType> getEventTypes(StandardAwsService service) {
        List<EventType> result = new ArrayList<>();
        for (EventType type : getValues()) {
            if (type.getService().equals(service)) {
                result.add(type);
            }
        }
        return result;
    }

    public String getEventName() {
        return eventName;
    }

    public StandardAwsService getService() {
        return service;
    }
}
