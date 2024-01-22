package com.oci.backend.employeeservice.awsservices;

import com.oci.backend.employeeservice.configurations.S3BucketConfig;
import com.oci.backend.employeeservice.models.User;
import com.oci.backend.employeeservice.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.util.Set;

@Component
@Slf4j
public class Ec2InstanceBuketService implements  BucketFileDownload<Set<User>>{
    @Override
    public Set<User> downloadFile(S3BucketConfig s3BucketConfig) {
        AwsCredentialsProvider provider = InstanceProfileCredentialsProvider.create();
        S3Client s3Client =   S3Client.builder().credentialsProvider(provider).region(Region.US_EAST_1).build();
        GetObjectRequest objectRequest = GetObjectRequest.builder().bucket(s3BucketConfig.getBucketName()).key(s3BucketConfig.getFileName()).build();
        var response = s3Client.getObjectAsBytes(objectRequest);
        var data = response.asByteArray();
        return MapperUtils.readAll(data);
    }
}
