package io.library.authorization.server.security_server.application.services;

import io.library.authorization.server.security_server.domain.entities.Client;

public interface ClientService {
    Client register(Client client);
    Client findByClientId(String clientId);
}
