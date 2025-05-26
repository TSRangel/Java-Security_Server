package io.library.authorization.server.security_server.application.services.impl;

import io.library.authorization.server.security_server.adapter.dtos.requests.ClientRequestDTO;
import io.library.authorization.server.security_server.adapter.dtos.responses.ClientResponseDTO;
import io.library.authorization.server.security_server.adapter.mappers.ClientMapper;
import io.library.authorization.server.security_server.adapter.repositories.ClientRepository;
import io.library.authorization.server.security_server.application.services.ClientService;
import io.library.authorization.server.security_server.application.services.exceptions.ResourceAlreadExistsException;
import io.library.authorization.server.security_server.application.services.exceptions.ResourceNotFoundException;
import io.library.authorization.server.security_server.domain.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDTO register(ClientRequestDTO dto) {
        Client newClient = clientMapper.toDomain(dto);

        if (clientRepository.findByClientId(newClient.getClientId()).isPresent()) {
            throw new ResourceAlreadExistsException("Client já registrado");
        }

        String secret = newClient.getClientSecret();
        newClient.setClientSecret(encoder.encode(secret));
        newClient = clientRepository.save(newClient);
        return clientMapper.toDTO(newClient);
    }

    @Override
    public ClientResponseDTO findByClientIdToDTO(String clientId) {
        Client client = clientRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client não encontrado nos registros."));

        return clientMapper.toDTO(client);
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client não encontrado nos registros."));
    }
}
