package com.test.contact_service.domain.ports.in;

import com.test.contact_service.domain.models.Contact;

import java.util.List;
import java.util.UUID;

public interface RetrieveContactUseCase {
    Contact retrieveById(UUID id);

    List<Contact> retrieveByCompanyId(Long companyId);

    List<Contact> retrieveAll();
}
