package com.test.contact_service.application.useCases.contact;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.in.contact.RetrieveContactUseCase;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

// Implementation
@RequiredArgsConstructor
public class RetrieveContactUseCaseImpl implements RetrieveContactUseCase {

    private final ContactRepositoryPort contactRepositoryPort;

    @Override
    public Contact retrieveById(UUID id) {
        return contactRepositoryPort.retrieveById(id);
    }

    @Override
    public List<Contact> retrieveByCompanyId(Long companyId) {
        return contactRepositoryPort.retrieveByCompanyId(companyId);
    }

    @Override
    public List<Contact> retrieveAll() {
        return contactRepositoryPort.retrieveAll();
    }
}
