package com.test.contact_service.application.useCases;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.in.CreateContactUseCase;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateContactUseCaseImpl implements CreateContactUseCase {

    private final ContactRepositoryPort contactRepositoryPort;

    @Override
    public Contact create(Contact contact) {
        return contactRepositoryPort.create(contact);
    }
}
