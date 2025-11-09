package com.test.contact_service.domain.ports.in.companyInformation;

import com.test.contact_service.domain.models.CompanyInformation;

public interface GetCompanyInformationUseCase {
    CompanyInformation get(Long companyId);
}
