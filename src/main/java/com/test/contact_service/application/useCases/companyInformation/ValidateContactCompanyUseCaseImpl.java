package com.test.contact_service.application.useCases.companyInformation;

import com.test.contact_service.domain.ports.in.companyInformation.ValidateCompanyInformationUseCase;
import com.test.contact_service.domain.ports.out.CompanyInformationRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidateCompanyInformationUseCaseImpl implements ValidateCompanyInformationUseCase {

    private final CompanyInformationRepositoryPort companyInformationRepositoryPort;

    @Override
    public Boolean validate(Long companyId) {
        return companyInformationRepositoryPort.validateCompanyInformation(companyId);
    }
}
