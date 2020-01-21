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

    public boolean numberIsValid(final int numberToConvert) {
        log.info("Checking to see if numberToConvert is valid...");
        if (numberToConvert == 0) {
            log.error("Number is not valid!");
            return false;
        }

        final boolean valid = numberToConvert >= lowerBound && numberToConvert <= upperBound;
        if (valid) {
            log.info("Number is valid...");
        } else {
            log.error("Number is not valid!");
        }
        return valid;
    }
}
