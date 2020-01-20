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
        if (numberToConvert == 0) {
            return false;
        }

        final double roundedUpNumberToConvert = Math.round(numberToConvert);
        return roundedUpNumberToConvert >= lowerBound && roundedUpNumberToConvert <= upperBound;
    }
}
