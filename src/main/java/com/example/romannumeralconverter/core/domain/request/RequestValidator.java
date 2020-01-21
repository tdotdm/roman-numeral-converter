package com.example.romannumeralconverter.core.domain.request;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestValidator {
    private final int lowerBound;
    private final int upperBound;

    public RequestValidator(final ApplicationProperties applicationProperties) {
        this.lowerBound = applicationProperties.getLowerBound();
        this.upperBound = applicationProperties.getUpperBound();
    }

    public boolean validate(final int numberToConvert) {
        if (numberToConvert == 0) {
            return false;
        }

        return numberToConvert >= lowerBound && numberToConvert <= upperBound;
    }
}
