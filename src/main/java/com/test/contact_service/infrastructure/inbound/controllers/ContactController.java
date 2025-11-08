package com.test.contact_service.infrastructure.inbound.controllers;

import com.test.contact_service.application.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/contact")
public class ContactController {

    private final ContactService contactService;


}
