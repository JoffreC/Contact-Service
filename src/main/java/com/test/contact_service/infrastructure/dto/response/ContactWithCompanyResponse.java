package com.test.contact_service.infrastructure.dto.response;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.models.ContactCompany;
import com.test.contact_service.domain.models.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ContactWithCompanyResponse {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private LocalDate birthday;
    private Gender gender;
    private Boolean isActive;
    private ContactCompany contactCompany;

    public static ContactWithCompanyResponse fromModel(Contact contact) {
        return ContactWithCompanyResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .middleName(contact.getMiddleName())
                .lastName(contact.getLastName())
                .nickname(contact.getNickname())
                .birthday(contact.getBirthday())
                .gender(contact.getGender())
                .isActive(contact.getIsActive())
                .build();
    }
}
