package com.oci.backend.employeeservice.repositories;

import com.oci.backend.employeeservice.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends JpaRepository<Country, Long> {
}

