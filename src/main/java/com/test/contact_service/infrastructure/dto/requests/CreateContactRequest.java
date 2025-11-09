package com.test.contact_service.infrastructure.dto.requests;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.models.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateContactRequest {
    @Size(max = 50, message = "First name must not exceed 50 characters.")
    private String firstName;

    @Size(max = 50, message = "Middle name must not exceed 50 characters.")
    private String middleName;

    @Size(max = 50, message = "Last name must not exceed 50 characters.")
    private String lastName;

    @NotBlank(message = "Nickname is required.")
    @Size(max = 20, message = "Nickname must not exceed 20 characters.")
    private String nickname;

    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;

    private Gender gender;

    @NotNull(message = "State is required")
    private Boolean isActive;

    private Long companyId;

    public Contact toModel(){
        return Contact.builder()
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
