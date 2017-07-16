package com.polaris.aws.service;

import com.amazonaws.services.s3.model.S3Object;

import java.util.Date;
import java.util.Map;

/**
 * Work with Aws S3
 * Created by Serhii_Nosko on 5/5/2016.
 */
public interface AwsS3Service {

    /**
     * Get keys of files
     *
     * @param accessKey  the access key
     * @param secretKey  the secret key
     * @param bucketName the bucket name
     * @return map of keys
     */
    Map<String, Date> getFiles(String accessKey, String secretKey, String bucketName);

    /**
     * Download file from S3
     *
     * @param accessKey  the access key
     * @param secretKey  the secret key
     * @param bucketName the bucket name
     * @param key        the file key
     * @return the downloaded data
     */
    byte[] downloadFile(String accessKey, String secretKey, String bucketName, String key);

    /**
     * Upload file to S3
     *
     * @param accessKey  the access key
     * @param secretKey  the secret key
     * @param bucketName the bucket name
     * @param s3Object   the s3 object
     */
    void uploadFile(String accessKey, String secretKey, String bucketName, S3Object s3Object);
}
