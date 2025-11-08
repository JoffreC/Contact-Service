package com.test.contact_service.domain.ports.out;

import com.test.contact_service.domain.models.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactRepositoryPort {
    Contact create(Contact contact);

    Contact retrieveById(UUID id);

    List<Contact> retrieveByCompanyId(Long companyId);

    List<Contact> retrieveAll();

    Contact update(Contact contact);

    void delete(UUID id);
}
