package com.polaris.aws.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.polaris.aws.service.AwsClientsFactory;
import com.polaris.aws.service.AwsS3Service;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by Serhii_Nosko on 5/5/2016.
 */
@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    private static final Log logger = LogFactory.getLog(AwsS3ServiceImpl.class);

    @Autowired
    private AwsClientsFactory clientsFactory;

    @Override
    public Map<String, Date> getFiles(String accessKey, String secretKey, String bucketName) {
        AmazonS3 s3Client = clientsFactory.getAwsS3Client(accessKey, secretKey);
        ListObjectsRequest request = new ListObjectsRequest().withBucketName(bucketName);

        // sort by date
        Map<String, Date> result = new TreeMap<>();

        ObjectListing list = s3Client.listObjects(request);
        List<S3ObjectSummary> objectSummaries = list.getObjectSummaries();
        objectSummaries.forEach(summary -> result.put(summary.getKey(), summary.getLastModified()));

        return result;
    }

    @Override
    public byte[] downloadFile(String accessKey, String secretKey, String bucketName, String key) {
        AmazonS3 s3Client = clientsFactory.getAwsS3Client(accessKey, secretKey);
        GetObjectRequest request = new GetObjectRequest(bucketName, key);

        S3Object s3Object = Optional.ofNullable(s3Client.getObject(request)).orElse(new S3Object());
        S3ObjectInputStream objectContent = s3Object.getObjectContent();

        byte[] result = null;
        try {
            result = IOUtils.toByteArray(objectContent);
        } catch (IOException e) {
            logger.error(String.format("Error reading %s log in %s bucket", key, bucketName), e);
            throw new RuntimeException(String.format("Error reading %s log in %s bucket", key, bucketName), e);
        }
        return result;
    }

    @Override
    public void uploadFile(String accessKey, String secretKey, String bucketName, S3Object s3Object) {
        AmazonS3 s3Client = clientsFactory.getAwsS3Client(accessKey, secretKey);
        s3Client.putObject(bucketName, s3Object.getKey(), s3Object.getObjectContent(), s3Object.getObjectMetadata());
    }
}
