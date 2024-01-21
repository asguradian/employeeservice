package com.oci.backend.employeeservice.utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oci.backend.employeeservice.models.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Set;

@Slf4j
public class MapperUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Set<User> readAll(final byte[] users) {
       log.info("Reading data from as bytes");
        try {
           return  objectMapper.readValue(users,new TypeReference<Set<User>>(){});
        } catch (IOException e) {
            log.error("Error reading files %s. Looks like the content of the file has changed..");
            throw new RuntimeException(e);
        }
    }
}
