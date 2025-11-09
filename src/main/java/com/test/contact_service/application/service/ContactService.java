package com.test.contact_service.application.service;

import com.test.contact_service.domain.models.ContactCompany;
import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.in.companyInformation.GetContactCompanyUseCase;
import com.test.contact_service.domain.ports.in.companyInformation.ValidateContactCompanyUseCase;
import com.test.contact_service.domain.ports.in.contact.CreateContactUseCase;
import com.test.contact_service.domain.ports.in.contact.DeleteContactUseCase;
import com.test.contact_service.domain.ports.in.contact.RetrieveContactUseCase;
import com.test.contact_service.domain.ports.in.contact.UpdateContactUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

// Service to access all use cases.
@RequiredArgsConstructor
public class ContactService implements CreateContactUseCase, RetrieveContactUseCase, UpdateContactUseCase, DeleteContactUseCase, GetContactCompanyUseCase, ValidateContactCompanyUseCase {

    private final CreateContactUseCase createContactUseCase;
    private final RetrieveContactUseCase retrieveContactUseCase;
    private final UpdateContactUseCase updateContactUseCase;
    private final DeleteContactUseCase deleteContactUseCase;
    private final GetContactCompanyUseCase getContactCompanyUseCase;
    private final ValidateContactCompanyUseCase validateContactCompanyUseCase;

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

    @Override
    public ContactCompany get(Long companyId) {
        return getContactCompanyUseCase.get(companyId);
    }

    @Override
    public void validate(Long companyId) {
        validateContactCompanyUseCase.validate(companyId);
    }
}
