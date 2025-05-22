package io.library.authorization.server.security_server.application.services.exceptions;

public class ResourceAlreadExistsException extends RuntimeException {
    public ResourceAlreadExistsException(String message) {
        super(message);
    }
}
