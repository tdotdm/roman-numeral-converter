package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NumeralValidator {
    private final int lowerBound;
    private final int upperBound;

    public NumeralValidator(final ApplicationProperties applicationProperties) {
        this.lowerBound = applicationProperties.getLowerBound();
        this.upperBound = applicationProperties.getUpperBound();
    }

    public boolean numeralIsValid(final int numeral) {
        return true;
    }
}
