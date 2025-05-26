package io.library.authorization.server.security_server.adapter.controllers;

import io.library.authorization.server.security_server.application.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


}
