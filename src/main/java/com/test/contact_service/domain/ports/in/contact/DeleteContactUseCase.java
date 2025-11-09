package com.test.contact_service.domain.ports.in.contact;

import java.util.UUID;

// Delete Use Case
public interface DeleteContactUseCase {
    void delete(UUID id);
}
