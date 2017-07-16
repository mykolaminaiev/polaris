package com.polaris.aws.exception;

import com.amazonaws.services.s3.model.S3Object;
import com.polaris.aws.service.AwsS3Service;
import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import com.polaris.persistence.entity.User;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.ByteArrayInputStream;

/**
 * Created by Mykola_Minaiev on 5/31/2017.
 */
@ControllerAdvice
@EnableWebMvc
public class AwsExceptionHandler {

    @Autowired
    private AwsS3Service s3Service;

    @Autowired
    private UserService userService;

    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(Exception e) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(loggedInUser.getName());
        AwsAccount awsAccount = user.getAwsAccount();
        AwsCloudTrailConfiguration trailConfiguration = awsAccount.getCloudTrailConfiguration();
        String bucketName = trailConfiguration.getBucket();
        S3Object s3Object = new S3Object();
        s3Object.setKey("exception");
        s3Object.setObjectContent(new ByteArrayInputStream(ExceptionUtils.getStackTrace(e).getBytes()));
        s3Service.uploadFile(awsAccount.getAccessKey(), awsAccount.getSecretKey(), bucketName, s3Object);
    }
}
