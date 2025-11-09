package com.test.contact_service.domain.ports.in;

import com.test.contact_service.domain.models.Contact;

public interface UpdateContactUseCase {
    Contact update(Contact contact);
}
