package com.Monstarlab.SonCH.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:commonProperties.properties")
@ConfigurationProperties(prefix = "jwt")
public class CommonProperties {
    private String secret;
    private Long expiration;
}
