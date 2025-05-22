package io.library.authorization.server.security_server.application.services.impl;

import io.library.authorization.server.security_server.adapter.repositories.ClientRepository;
import io.library.authorization.server.security_server.application.services.ClientService;
import io.library.authorization.server.security_server.application.services.exceptions.ResourceAlreadExistsException;
import io.library.authorization.server.security_server.application.services.exceptions.ResourceNotFoundException;
import io.library.authorization.server.security_server.domain.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client register(Client client) {
        if(clientRepository.findByClientId(client.getClientId()).isPresent()) {
            throw new ResourceAlreadExistsException("Client já registrado");
        }
        return clientRepository.save(client);
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client não encontrado nos registros."));
    }
}
