package com.github.tdotdm.core.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application-properties")
@Configuration
@Data
public class ApplicationProperties {
    private String numberToConvert;
    private int lowerBound;
    private int upperBound;
}
