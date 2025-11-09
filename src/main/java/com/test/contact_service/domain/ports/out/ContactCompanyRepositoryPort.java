package com.test.contact_service.domain.ports.out;

import com.test.contact_service.domain.models.CompanyInformation;

public interface CompanyInformationRepositoryPort {
    CompanyInformation getCompanyInformation(Long companyId);
    Boolean validateCompanyInformation(Long companyId);
}
