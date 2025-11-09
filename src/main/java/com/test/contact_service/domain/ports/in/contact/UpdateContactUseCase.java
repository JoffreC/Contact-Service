package com.test.contact_service.domain.ports.in.contact;

import com.test.contact_service.domain.models.Contact;

// Update Use Case
public interface UpdateContactUseCase {
    Contact update(Contact contact);
}
