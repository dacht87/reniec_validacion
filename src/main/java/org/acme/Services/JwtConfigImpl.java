package org.acme.Services;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.interfaces.IjwtConfig;

@ApplicationScoped
public class JwtConfigImpl implements IjwtConfig {

    @ConfigProperty(name = "jwt.secret-key")
    String secretKey;

    @Override
    public String getSecretKey() {
        return secretKey;
    }
}