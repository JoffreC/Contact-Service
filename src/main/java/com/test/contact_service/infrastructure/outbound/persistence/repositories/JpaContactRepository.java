package com.test.contact_service.infrastructure.outbound.persistence.repositories;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.infrastructure.outbound.persistence.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaContactRepository extends JpaRepository<ContactEntity, UUID> {
    List<ContactEntity> findByCompanyId(Long companyId);
}
