package com.test.contact_service.infrastructure.outbound.external;

import com.test.contact_service.domain.models.ContactCompany;
import com.test.contact_service.domain.ports.out.ContactCompanyRepositoryPort;
import com.test.contact_service.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ContactCompanyRestClient implements ContactCompanyRepositoryPort {

    private final WebClient webClient;

    public ContactCompanyRestClient(WebClient.Builder builder,
                                    @Value("${company.service.url}") String baseUrl) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }
    // External service port use cases implementation
    // Get information in external service
    @Override
    public ContactCompany get(Long companyId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/get-essential-info-by-id")
                        .queryParam("id", companyId)
                        .build()
                )
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new ResourceNotFoundException("Company not found"))
                )
                .bodyToMono(ContactCompany.class)
                .block();
    }

    // Validate id in external service
    @Override
    public void validate(Long companyId) {
        Boolean result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/validate")
                        .queryParam("id", companyId)
                        .build()
                )
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (Boolean.FALSE.equals(result)) {
            throw new ResourceNotFoundException("Company not found");
        }
    }
}
