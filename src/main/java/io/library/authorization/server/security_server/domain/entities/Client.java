package io.library.authorization.server.security_server.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "tb_client")
public class Client extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String clientId;
    @Column(nullable = false)
    private String clientSecret;
    @Column(nullable = false, name = "redirect_uri")
    private String redirectURI;
    @Column(nullable = false)
    private String scope;
}
