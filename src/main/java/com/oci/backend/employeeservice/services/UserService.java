package com.oci.backend.employeeservice.services;

import com.oci.backend.employeeservice.awsservices.BasicAuthNBucketService;
import com.oci.backend.employeeservice.awsservices.BucketFileDownload;
import com.oci.backend.employeeservice.awsservices.Ec2InstanceBuketService;
import com.oci.backend.employeeservice.configurations.S3BucketConfig;
import com.oci.backend.employeeservice.models.User;
import com.oci.backend.employeeservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class UserService {

    @Autowired
    private Ec2InstanceBuketService bucketService;
    @Autowired
    private S3BucketConfig s3BucketConfig;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/loadUsers")
    @Transactional
    public Collection<User> loadUsers() {
        userRepository.findAll();
        Set<User> users = bucketService.downloadFile(s3BucketConfig);
        return userRepository.saveAll(users);
    }
    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
