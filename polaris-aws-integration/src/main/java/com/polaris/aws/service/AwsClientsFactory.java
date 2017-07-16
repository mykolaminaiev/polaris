package com.polaris.aws.service;

import com.amazonaws.services.cloudtrail.AWSCloudTrail;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.s3.AmazonS3;

/**
 * Used for retrieve Aws clients
 * Created by Serhii_Nosko on 5/5/2016.
 */
public interface AwsClientsFactory {

    /**
     * Get EC2 client
     *
     * @param accessKey the access key
     * @param secretKet the secret key
     * @param endpoint  zone endpoint
     * @return EC2 client
     */
    AmazonEC2 getEC2Client(String accessKey, String secretKet, String endpoint);

    /**
     * Get S3 client
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     * @return Aws S3 client
     */
    AmazonS3 getAwsS3Client(String accessKey, String secretKey);

    /**
     * Get Cloud Trail client
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     * @return Cloud Trail client
     */
    AWSCloudTrail getCloudTrailClient(String accessKey, String secretKey);
}
