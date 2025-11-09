package com.test.contact_service.domain.ports.in.contact;

import com.test.contact_service.domain.models.Contact;

import java.util.List;
import java.util.UUID;

// Retrieve Use Case
public interface RetrieveContactUseCase {
    Contact retrieveById(UUID id);

    List<Contact> retrieveByCompanyId(Long companyId);

    List<Contact> retrieveAll();
}
