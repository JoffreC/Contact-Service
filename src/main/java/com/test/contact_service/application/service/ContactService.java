package com.test.contact_service.application.service;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.in.CreateContactUseCase;
import com.test.contact_service.domain.ports.in.DeleteContactUseCase;
import com.test.contact_service.domain.ports.in.RetrieveContactUseCase;
import com.test.contact_service.domain.ports.in.UpdateContactUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ContactService implements CreateContactUseCase, RetrieveContactUseCase, UpdateContactUseCase, DeleteContactUseCase {

    private final CreateContactUseCase createContactUseCase;
    private final RetrieveContactUseCase retrieveContactUseCase;
    private final UpdateContactUseCase updateContactUseCase;
    private final DeleteContactUseCase deleteContactUseCase;

    @Override
    public Contact create(Contact contact) {
        return createContactUseCase.create(contact);
    }

    @Override
    public void delete(UUID id) {
        deleteContactUseCase.delete(id);
    }

    @Override
    public Contact retrieveById(UUID id) {
        return retrieveContactUseCase.retrieveById(id);
    }

    @Override
    public List<Contact> retrieveByCompanyId(Long companyId) {
        return retrieveContactUseCase.retrieveByCompanyId(companyId);
    }

    @Override
    public List<Contact> retrieveAll() {
        return retrieveContactUseCase.retrieveAll();
    }

    @Override
    public Contact update(Contact contact) {
        return updateContactUseCase.update(contact);
    }
}
