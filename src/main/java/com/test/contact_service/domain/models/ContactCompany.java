package com.test.contact_service.domain.models;

import lombok.Data;

// Domain model for information of the external service Company-Service
@Data
public class ContactCompany {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isActive;
}
