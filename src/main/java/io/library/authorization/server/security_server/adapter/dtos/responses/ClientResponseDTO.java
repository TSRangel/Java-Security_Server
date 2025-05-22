package io.library.authorization.server.security_server.adapter.dtos.responses;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponseDTO(
        UUID id,
        String clientId,
        String clientSecret,
        String redirectUri,
        String scope,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-ss HH:mm:ss", timezone = "GMT")
        LocalDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-ss HH:mm:ss", timezone = "GMT")
        LocalDateTime updatedAt
) {
}
