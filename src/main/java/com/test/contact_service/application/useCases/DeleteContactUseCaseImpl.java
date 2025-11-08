package com.test.contact_service.application.useCases;

import com.test.contact_service.domain.ports.in.DeleteContactUseCase;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteContactUseCaseImpl implements DeleteContactUseCase {

    private final ContactRepositoryPort contactRepositoryPort;

    @Override
    public void delete(UUID id) {
        contactRepositoryPort.delete(id);
    }
}
