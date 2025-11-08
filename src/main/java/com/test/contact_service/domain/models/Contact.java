package com.test.contact_service.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Contact {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private Date birthday;
    private Gender gender;
    private Boolean isActive;
    private Long companyId;
}
