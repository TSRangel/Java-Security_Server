package io.library.authorization.server.security_server.adapter.dtos.requests;

public record ClientRequestDTO(
        String clientId,
        String clientSecret,
        String redirectUri,
        String scope
) {
}

