package com.oci.backend.employeeservice.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class WhereAmIService {

    @GetMapping("/whereAmI" )
    public String whereAmI() throws  Exception {
        InetAddress IP= InetAddress.getLocalHost();
        return IP.getHostAddress();
    }
}
