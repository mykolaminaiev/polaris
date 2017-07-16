package com.polaris.aws.service;

import com.polaris.aws.model.AwsCloudTrailInfo;
import com.polaris.persistence.entity.AwsAccount;

import java.util.List;

/**
 * The interface IAwsCloudTrailService
 * Created by Serhii_Nosko on 11/27/2015.
 */
public interface AwsCloudTrailService {

    /**
     * Activate cloud trail
     *
     * @param account       the aws account
     * @param bucketName    the bucketName
     * @param logFilePrefix the logFilePrefix
     * @return the Cloud Trail configuration
     */
    AwsCloudTrailInfo activate(AwsAccount account, String bucketName, String logFilePrefix);

    /**
     * Deactivate Cloud Trail
     */
    void deactivate();

    /**
     * Describe Cloud Trail
     *
     * @param account the aws account
     * @return list of Cloud Trail configurations
     */
    List<AwsCloudTrailInfo> describe(AwsAccount account);
}
