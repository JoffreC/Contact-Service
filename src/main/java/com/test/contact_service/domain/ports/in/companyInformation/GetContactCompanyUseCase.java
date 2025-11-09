package com.test.contact_service.domain.ports.in.companyInformation;

import com.test.contact_service.domain.models.ContactCompany;

// Use case to get information of external service Company Service
public interface GetContactCompanyUseCase {
    ContactCompany get(Long companyId);
}
