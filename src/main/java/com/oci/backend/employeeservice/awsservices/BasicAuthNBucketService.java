package com.oci.backend.employeeservice.awsservices;

import com.oci.backend.employeeservice.configurations.AwsAuthenticationConfig;
import com.oci.backend.employeeservice.configurations.S3BucketConfig;
import com.oci.backend.employeeservice.models.User;
import com.oci.backend.employeeservice.utils.MapperUtils;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class BasicAuthNBucketService implements  BucketFileDownload<Set<User>> {

    @Autowired
    private AwsAuthenticationConfig awsAuthenticationConfig;
    S3Client s3Client;
   private void initializeawsClient() {
        AwsCredentialsProvider provider = StaticCredentialsProvider.create(AwsBasicCredentials.create(awsAuthenticationConfig.getAccessKey(), awsAuthenticationConfig.getSecretKey()));
         s3Client =  S3Client.builder().credentialsProvider(provider).region(Region.US_EAST_1).build();
   }

    @Override
    public Set<User> downloadFile(S3BucketConfig s3BucketConfig) {
       log.info("Downloading file from object storage...");
       initializeawsClient();
        GetObjectRequest objectRequest = GetObjectRequest.builder().bucket(s3BucketConfig.getBucketName()).key(s3BucketConfig.getFileName()).build();
        var response = s3Client.getObjectAsBytes(objectRequest);
        var data = response.asByteArray();
        return MapperUtils.readAll(data);
    }
}
