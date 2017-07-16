package com.polaris.aws.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
public enum StandardAwsService {
    AMAZON_ELASTIC_MAP_REDUCE(StandardAwsServiceGroup.ANALYTICS),
    AUTO_SCALING(StandardAwsServiceGroup.COMPUTE),
    AWS_CERTIFICATE_MANAGER(StandardAwsServiceGroup.SECURITY_AND_IDENTITY),
    AWS_CLOUD_FORMATION(StandardAwsServiceGroup.MANAGEMENT_TOOLS),
    AMAZON_CLOUD_FRONT(StandardAwsServiceGroup.STORAGE_AND_CONTENT_DELIVERY),
    AWS_CLOUD_HSM(StandardAwsServiceGroup.SECURITY_AND_IDENTITY),
    AMAZON_CLOUD_SEARCH(StandardAwsServiceGroup.APPLICATION_SERVICES),
    AWS_CLOUD_TRAIL(StandardAwsServiceGroup.MANAGEMENT_TOOLS),
    AMAZON_CLOUD_WATCH(StandardAwsServiceGroup.MANAGEMENT_TOOLS),
    AWS_CODE_DEPLOY(StandardAwsServiceGroup.DEVELOPER_TOOLS),
    AMAZON_COGNITO_IDENTITY(StandardAwsServiceGroup.MOBILE_SERVICES),
    AMAZON_COGNITO_SYNC(StandardAwsServiceGroup.MOBILE_SERVICES),
    AWS_CONFIG(StandardAwsServiceGroup.MANAGEMENT_TOOLS),
    AWS_DATA_PIPELINE(StandardAwsServiceGroup.ANALYTICS),
    AWS_DIRECT_CONNECT(StandardAwsServiceGroup.NETWORKING),
    AMAZON_DYNAMO_DB(StandardAwsServiceGroup.DATABASE),
    AMAZON_EC2(StandardAwsServiceGroup.COMPUTE),
    AWS_ELASTIC_BEANSTALK(StandardAwsServiceGroup.COMPUTE),
    ELASTIC_LOAD_BALANCING(StandardAwsServiceGroup.COMPUTE),
    AMAZON_ELASTIC_TRANSCODER(StandardAwsServiceGroup.APPLICATION_SERVICES),
    AMAZON_ELASTIC_CACHE(StandardAwsServiceGroup.DATABASE),
    AMAZON_GLACIER(StandardAwsServiceGroup.STORAGE_AND_CONTENT_DELIVERY),
    AWS_IDENTITY_AND_ACCESS_MANAGEMENT(StandardAwsServiceGroup.SECURITY_AND_IDENTITY),
    AMAZON_INSPECTOR(StandardAwsServiceGroup.SECURITY_AND_IDENTITY),
    AWS_IOT(StandardAwsServiceGroup.INTERNET_OF_THINGS),
    AMAZON_KINESIS_FIREHOSE(StandardAwsServiceGroup.ANALYTICS),
    AMAZON_KINESIS_STREAMS(StandardAwsServiceGroup.ANALYTICS),
    AWS_OPS_WORKS(StandardAwsServiceGroup.MANAGEMENT_TOOLS),
    AMAZON_REDSHIFT(StandardAwsServiceGroup.ANALYTICS),
    AMAZON_RELATION_DATABASE_SERVICE(StandardAwsServiceGroup.DATABASE),
    AMAZON_ROUTE_53(StandardAwsServiceGroup.NETWORKING),
    AMAZON_S3_BUCKET_LEVEL(StandardAwsServiceGroup.STORAGE_AND_CONTENT_DELIVERY),
    AMAZON_SIMPLE_WORKFLOW_SERVICE(StandardAwsServiceGroup.APPLICATION_SERVICES),
    AWS_STORAGE_GATEWAY(StandardAwsServiceGroup.STORAGE_AND_CONTENT_DELIVERY),
    AWS_SUPPORT(StandardAwsServiceGroup.SUPPORT),
    AWS_WAF(StandardAwsServiceGroup.SECURITY_AND_IDENTITY),
    AMAZON_WORK_DOCS(StandardAwsServiceGroup.ENTERPRISE_APPLICATIONS);

    private static final StandardAwsService[] VALUES = StandardAwsService.values();
    private StandardAwsServiceGroup group;

    StandardAwsService(StandardAwsServiceGroup group) {
        this.group = group;
    }

    public static List<StandardAwsService> getServiceTypes(StandardAwsServiceGroup groupType) {
        List<StandardAwsService> result = new ArrayList<>();
        for (StandardAwsService type : VALUES) {
            if (type.getGroup().equals(groupType)) {
                result.add(type);
            }
        }
        return result;
    }

    public StandardAwsServiceGroup getGroup() {
        return group;
    }
}
