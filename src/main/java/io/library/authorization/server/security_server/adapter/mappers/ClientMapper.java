package io.library.authorization.server.security_server.adapter.mappers;

import io.library.authorization.server.security_server.adapter.dtos.requests.ClientRequestDTO;
import io.library.authorization.server.security_server.adapter.dtos.responses.ClientResponseDTO;
import io.library.authorization.server.security_server.domain.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toDomain(ClientRequestDTO dto);
    ClientResponseDTO toDTO(Client client);
}
