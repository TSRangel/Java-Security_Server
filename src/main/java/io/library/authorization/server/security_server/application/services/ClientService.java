package io.library.authorization.server.security_server.application.services;

import io.library.authorization.server.security_server.adapter.dtos.requests.ClientRequestDTO;
import io.library.authorization.server.security_server.adapter.dtos.responses.ClientResponseDTO;
import io.library.authorization.server.security_server.domain.entities.Client;

import java.util.Optional;

public interface ClientService {
    ClientResponseDTO register(ClientRequestDTO dto);
    Client findByClientId(String clientId);
    ClientResponseDTO findByClientIdToDTO(String clientId);
}
