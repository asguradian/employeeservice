package com.oci.backend.employeeservice.awsservices;

import com.oci.backend.employeeservice.configurations.S3BucketConfig;

public interface BucketFileDownload<T> {

    public  T downloadFile(S3BucketConfig s3BucketConfig);

}
