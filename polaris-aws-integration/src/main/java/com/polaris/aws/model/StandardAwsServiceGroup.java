package com.polaris.aws.model;

/**
 * Created by Serhii_Nosko on 2016.
 */
public enum StandardAwsServiceGroup {
    ANALYTICS,
    APPLICATION_SERVICES,
    COMPUTE,
    DATABASE,
    DEVELOPER_TOOLS,
    ENTERPRISE_APPLICATIONS,
    INTERNET_OF_THINGS,
    GAME_DEVELOPMENT,
    MANAGEMENT_TOOLS,
    MOBILE_SERVICES,
    NETWORKING,
    SECURITY_AND_IDENTITY,
    STORAGE_AND_CONTENT_DELIVERY,
    SUPPORT;

    private static final StandardAwsServiceGroup[] VALUES = StandardAwsServiceGroup.values();

    public static StandardAwsServiceGroup fromName(String name) {
        StandardAwsServiceGroup result = null;
        for (StandardAwsServiceGroup group : VALUES) {
            if (group.name().equalsIgnoreCase(name)) {
                result = group;
                break;
            }
        }
        return result;
    }
}
