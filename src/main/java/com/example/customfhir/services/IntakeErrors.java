package com.example.customfhir.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class IntakeErrors {

    private IntakeErrors() {
    }

    public static ResponseStatusException notFound(String resource, Long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, resource + " not found for id " + id);
    }
}

