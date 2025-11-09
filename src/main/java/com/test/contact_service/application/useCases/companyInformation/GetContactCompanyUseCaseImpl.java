package com.test.contact_service.application.useCases.companyInformation;

import com.test.contact_service.domain.models.ContactCompany;
import com.test.contact_service.domain.ports.in.companyInformation.GetContactCompanyUseCase;
import com.test.contact_service.domain.ports.out.ContactCompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class GetContactCompanyUseCaseImpl implements GetContactCompanyUseCase {

    private final ContactCompanyRepositoryPort contactCompanyRepositoryPort;

    @Override
    public ContactCompany get(Long companyId) {
        return contactCompanyRepositoryPort.get(companyId);
    }
}
