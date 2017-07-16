package com.polaris.aws.service;

import com.polaris.persistence.entity.AwsAccount;

/**
 * Created by Serhii_Nosko on 5/5/2016.
 */
public interface AwsAnalyticsService {

    void processLatestLogs(AwsAccount awsAccount);
}
