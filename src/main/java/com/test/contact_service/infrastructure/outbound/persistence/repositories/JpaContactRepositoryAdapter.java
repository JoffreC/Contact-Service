package com.test.contact_service.infrastructure.outbound.persistence.repositories;

import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.domain.ports.out.ContactRepositoryPort;
import com.test.contact_service.infrastructure.exceptions.ResourceNotFoundException;
import com.test.contact_service.infrastructure.outbound.persistence.entities.ContactEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaContactRepositoryAdapter implements ContactRepositoryPort {

    private final JpaContactRepository jpaContactRepository;

    @Override
    public Contact create(Contact contact) {
        ContactEntity contactEntity = ContactEntity.fromModel(contact);
        return jpaContactRepository.save(contactEntity).toModel();
    }

    @Override
    public Contact retrieveById(UUID id) {
        return jpaContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"))
                .toModel();
    }

    @Override
    public List<Contact> retrieveByCompanyId(Long companyId) {
        return jpaContactRepository.findByCompanyId(companyId)
                .stream()
                .map(ContactEntity::toModel)
                .toList();
    }

    @Override
    public List<Contact> retrieveAll() {
        return jpaContactRepository.findAll()
                .stream()
                .map(ContactEntity::toModel)
                .toList();
    }

    @Override
    public Contact update(Contact contact) {
        return jpaContactRepository.findById(contact.getId())
                .map(contactEntity -> jpaContactRepository.save(updateAttributes(contactEntity, contact)))
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"))
                .toModel();
    }

    @Override
    public void delete(UUID id) {
        jpaContactRepository.deleteById(id);
    }

    private ContactEntity updateAttributes(ContactEntity contactEntity, Contact contact) {
        contactEntity.setFirstName(contact.getFirstName());
        contactEntity.setMiddleName(contact.getMiddleName());
        contactEntity.setLastName(contact.getLastName());
        contactEntity.setNickname(contact.getNickname());
        contactEntity.setBirthday(contact.getBirthday());
        contactEntity.setIsActive(contact.getIsActive());
        contactEntity.setCompanyId(contactEntity.getCompanyId());
        return contactEntity;

    }
}
