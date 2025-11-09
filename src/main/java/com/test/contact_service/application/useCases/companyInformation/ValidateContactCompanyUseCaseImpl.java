package com.test.contact_service.application.useCases.companyInformation;

import com.test.contact_service.domain.ports.in.companyInformation.ValidateContactCompanyUseCase;
import com.test.contact_service.domain.ports.out.ContactCompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class ValidateContactCompanyUseCaseImpl implements ValidateContactCompanyUseCase {

    private final ContactCompanyRepositoryPort contactCompanyRepositoryPort;

    @Override
    public void validate(Long companyId) {contactCompanyRepositoryPort.validate(companyId);
    }
}
