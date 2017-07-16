package com.polaris.aws.service.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudtrail.AWSCloudTrail;
import com.amazonaws.services.cloudtrail.AWSCloudTrailClient;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.polaris.aws.service.AwsClientsFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii_Nosko on 5/5/2016.
 */
@Service
public class AwsClientsFactoryImpl implements AwsClientsFactory {

    @Override
    public AmazonEC2 getEC2Client(String accessKey, String secretKey, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonEC2 client = new AmazonEC2Client(credentials);
        client.setEndpoint(endpoint);
        return client;
    }

    @Override
    public AmazonS3 getAwsS3Client(String accessKey, String secretKey) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AmazonS3Client(credentials);
    }

    @Override
    public AWSCloudTrail getCloudTrailClient(String accessKey, String secretKey) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AWSCloudTrailClient(credentials);
    }
}
