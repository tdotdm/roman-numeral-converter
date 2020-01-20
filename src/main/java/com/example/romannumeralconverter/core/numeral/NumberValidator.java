package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NumberValidator {
    private final int lowerBound;
    private final int upperBound;

    public NumberValidator(final ApplicationProperties applicationProperties) {
        this.lowerBound = applicationProperties.getLowerBound();
        this.upperBound = applicationProperties.getUpperBound();
    }

    public boolean numberIsValid(final int numberToConvert) {
        log.info("Checking to see if number is valid...");
        if (numberToConvert == 0) {
            log.error("Number is not valid!");
            return false;
        }

        log.info("Number is valid.");
        return numberToConvert >= lowerBound && numberToConvert <= upperBound;
    }
}
