package com.test.contact_service.infrastructure.config;

import com.test.contact_service.application.service.ContactService;
import com.test.contact_service.application.useCases.companyInformation.GetContactCompanyUseCaseImpl;
import com.test.contact_service.application.useCases.companyInformation.ValidateContactCompanyUseCaseImpl;
import com.test.contact_service.application.useCases.contact.CreateContactUseCaseImpl;
import com.test.contact_service.application.useCases.contact.DeleteContactUseCaseImpl;
import com.test.contact_service.application.useCases.contact.RetrieveContactUseCaseImpl;
import com.test.contact_service.application.useCases.contact.UpdateContactUseCaseImpl;
import com.test.contact_service.domain.ports.in.companyInformation.GetContactCompanyUseCase;
import com.test.contact_service.domain.ports.in.companyInformation.ValidateContactCompanyUseCase;
import com.test.contact_service.domain.ports.out.ContactCompanyRepositoryPort;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import com.test.contact_service.infrastructure.outbound.persistence.repositories.JpaContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Beans configuration
@Configuration
public class ApplicationConfig {

    @Bean
    public ContactService contactService(ContactRepositoryPort contactRepositoryPort, GetContactCompanyUseCase getContactCompanyUseCase, ValidateContactCompanyUseCase validateContactCompanyUseCase) {
        return new ContactService(
                new CreateContactUseCaseImpl(contactRepositoryPort),
                new RetrieveContactUseCaseImpl(contactRepositoryPort),
                new UpdateContactUseCaseImpl(contactRepositoryPort),
                new DeleteContactUseCaseImpl(contactRepositoryPort),
                getContactCompanyUseCase,
                validateContactCompanyUseCase
        );
    }

    @Bean
    public ContactRepositoryPort contactRepositoryPort(JpaContactRepositoryAdapter jpaContactRepositoryAdapter) {
        return jpaContactRepositoryAdapter;
    }

    @Bean
    public GetContactCompanyUseCase getContactCompanyUseCase(ContactCompanyRepositoryPort contactCompanyRepositoryPort) {
        return new GetContactCompanyUseCaseImpl(contactCompanyRepositoryPort);
    }

    @Bean
    ValidateContactCompanyUseCase validateContactCompanyUseCase(ContactCompanyRepositoryPort contactCompanyRepositoryPort) {
        return new ValidateContactCompanyUseCaseImpl(contactCompanyRepositoryPort);
    }


}
