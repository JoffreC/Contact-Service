package com.test.contact_service.infrastructure.outbound.persistence.entities;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.models.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String nickname;

    private LocalDate birthday;

    private Gender gender;

    @Column(nullable = false)
    private Boolean isActive;

    private Long companyId;

    // Map Contact (domain model) to ContactEntity
    public static ContactEntity fromModel(Contact contact) {
        return ContactEntity.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .middleName(contact.getMiddleName())
                .lastName(contact.getLastName())
                .nickname(contact.getNickname())
                .birthday(contact.getBirthday())
                .gender(contact.getGender())
                .isActive(contact.getIsActive())
                .companyId(contact.getCompanyId())
                .build();
    }

    // Map ContactEntity to Contact (domain model)
    public Contact toModel(){
        return Contact.builder()
                .id(id)
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .nickname(nickname)
                .birthday(birthday)
                .gender(gender)
                .isActive(isActive)
                .companyId(companyId)
                .build();
    }
}
