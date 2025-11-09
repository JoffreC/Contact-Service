package com.test.contact_service.domain.ports.out;

import com.test.contact_service.domain.models.ContactCompany;

// External information port
public interface ContactCompanyRepositoryPort {
    ContactCompany get(Long companyId);
    void validate(Long companyId);
}
