package com.test.contact_service.domain.ports.in;

import java.util.UUID;

public interface DeleteContactUseCase {
    void delete(UUID id);
}
