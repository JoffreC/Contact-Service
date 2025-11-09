package com.test.contact_service.domain.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

// Domain model
@Data
@Builder
public class Contact {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private LocalDate birthday;
    private Gender gender;
    private Boolean isActive;
    private Long companyId;
}
