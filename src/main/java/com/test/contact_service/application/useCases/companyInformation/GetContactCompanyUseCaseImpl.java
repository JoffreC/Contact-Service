package com.test.contact_service.application.useCases.companyInformation;

import com.test.contact_service.domain.models.CompanyInformation;
import com.test.contact_service.domain.ports.in.companyInformation.GetCompanyInformationUseCase;
import com.test.contact_service.domain.ports.out.CompanyInformationRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetCompanyInformationUseCaseImpl implements GetCompanyInformationUseCase {

    private final CompanyInformationRepositoryPort companyInformationRepositoryPort;

    @Override
    public CompanyInformation get(Long companyId) {
        return companyInformationRepositoryPort.getCompanyInformation(companyId);
    }
}
