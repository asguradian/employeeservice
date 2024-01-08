package com.oci.backend.employeeservice.services;

import com.oci.backend.employeeservice.models.Country;
import com.oci.backend.employeeservice.repositories.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/students")
    public List<Country> getAll() {
        log.info("Entring in country fetch all details...");
        var result = countryRepository.findAll();
        return result;
    }
}
