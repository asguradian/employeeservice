package com.oci.backend.employeeservice.configurations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "s3")
@Data
public class S3BucketConfig {
    String bucketName;
    String fileName;
}
