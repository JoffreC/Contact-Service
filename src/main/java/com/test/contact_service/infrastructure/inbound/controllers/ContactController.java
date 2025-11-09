package com.test.contact_service.infrastructure.inbound.controllers;

import com.test.contact_service.application.service.ContactService;
import com.test.contact_service.domain.models.Contact;
import com.test.contact_service.infrastructure.dto.requests.CreateContactRequest;
import com.test.contact_service.infrastructure.dto.requests.UpdateContactRequest;
import com.test.contact_service.infrastructure.dto.response.ApiResponse;
import com.test.contact_service.infrastructure.dto.response.ContactResponse;
import com.test.contact_service.infrastructure.dto.response.ContactWithCompanyResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/contact")
public class ContactController {

    private final ContactService contactService;

    @Operation(summary = "Create contact", description = "endpoint to create contact")
    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateContactRequest createContactRequest) {
        contactService.validate(createContactRequest.getCompanyId()); // validate id in company service
        Contact createdContact = contactService.create(createContactRequest.toModel());
        URI uri = URI.create("/get-by-id/" + createdContact.getId());
        return ResponseEntity.created(uri).body(new ApiResponse("Successfully created contact", createdContact));
    }

    @Operation(summary = "Retrieve contact by id", description = "Endpoint to retrieve a contact by its id")
    @GetMapping("get-by-id")
    public ResponseEntity<ApiResponse> getById(@RequestParam UUID id) {
        Contact contact = contactService.retrieveById(id);
        ContactWithCompanyResponse contactWithCompanyResponse = ContactWithCompanyResponse.fromModel(contact);
        contactWithCompanyResponse.setContactCompany(contactService.get(contact.getCompanyId())); // get information in company service
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved contact", contactWithCompanyResponse));
    }

    @Operation(summary = "Retrieve all contacts", description = "Endpoint to retrieve all contacts")
    @GetMapping("get-all")
    public ResponseEntity<ApiResponse> getAll() {
        List<Contact> contacts = contactService.retrieveAll();
        List<ContactWithCompanyResponse> contactWithCompanyResponses = contacts.stream()
                .map(contact -> {
                    ContactWithCompanyResponse contactWithCompanyResponse = ContactWithCompanyResponse.fromModel(contact);
                    contactWithCompanyResponse.setContactCompany(contactService.get(contact.getCompanyId())); // get information in company service
                    return contactWithCompanyResponse;
                })
                .toList();
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved all contacts", contactWithCompanyResponses));
    }

    @Operation(summary = "Retrieve contacts by company id", description = "Endpoint to retrieve contacts by company id")
    @GetMapping("get-by-company-id")
    public ResponseEntity<List<ContactResponse>> getByCompanyId(@RequestParam Long companyId) {
        List<Contact> contacts = contactService.retrieveByCompanyId(companyId);
        List<ContactResponse> contactResponses = contacts.stream()
                .map(ContactResponse::fromModel)
                .toList();
        return ResponseEntity.ok(contactResponses);
    }

    @Operation(summary = "Update contact", description = "Endpoint to update all contacts")
    @PutMapping("update")
    public ResponseEntity<ApiResponse> update(@RequestBody UpdateContactRequest updateContactRequest) {
        contactService.validate(updateContactRequest.getCompanyId()); // validate id in company service
        Contact updatedContact = contactService.update(updateContactRequest.toModel());
        ContactWithCompanyResponse contactWithCompanyResponse = ContactWithCompanyResponse.fromModel(updatedContact);
        contactWithCompanyResponse.setContactCompany(contactService.get(updatedContact.getCompanyId()));
        return ResponseEntity.ok(new ApiResponse("Successfully updated contact", contactWithCompanyResponse));
    }

    @Operation(summary = "Delete contact", description = "Endpoint to delete a contact")
    @DeleteMapping("delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam UUID id) {
        contactService.delete(id);
        return ResponseEntity.ok(new ApiResponse("Successfully deleted contact", null));
    }
}
