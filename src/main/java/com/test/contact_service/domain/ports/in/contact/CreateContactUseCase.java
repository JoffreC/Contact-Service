package com.test.contact_service.domain.ports.in.contact;

import com.test.contact_service.domain.models.Contact;

// Create Use Case
public interface CreateContactUseCase {
    Contact create(Contact contact);
}
