package com.test.contact_service.application.useCases.contact;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.in.contact.UpdateContactUseCase;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class UpdateContactUseCaseImpl implements UpdateContactUseCase {

    private final ContactRepositoryPort contactRepositoryPort;

    @Override
    public Contact update(Contact contact) {
        return contactRepositoryPort.update(contact);
    }
}
