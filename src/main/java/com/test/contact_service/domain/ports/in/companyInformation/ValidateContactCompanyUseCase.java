package com.test.contact_service.domain.ports.in.companyInformation;

// Use case to validate an id of external service Company Service
public interface ValidateContactCompanyUseCase {
    void validate(Long companyId);
}
