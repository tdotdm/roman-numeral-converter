package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.domain.numberrequest.NumberRequestValidator;
import com.example.romannumeralconverter.core.domain.numberrequest.StringToIntegerConverter;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class Delegator {
    private final StringToIntegerConverter stringToIntegerConverter;
    private final NumberRequestValidator numberRequestValidator;
    private final RomanNumeralGenerator romanNumeralGenerator;

    public void delegate(final String numberRequest) {
        final Optional<Integer> optionalNumberToConvert = stringToIntegerConverter.convert(numberRequest);
        if (optionalNumberToConvert.isPresent()) {
            final Integer numberToConvert = optionalNumberToConvert.get();
            final boolean numberIsValid = numberRequestValidator.numberIsValid(numberToConvert);

            if (numberIsValid) {
                log.info("Converting {} to Roman numeral.", numberToConvert);
                final String romanNumeral = romanNumeralGenerator.generate(numberToConvert);
                log.info("******************************");
                log.info(romanNumeral);
                log.info("******************************");
            } else {
                log.error("Number is not valid and cannot be converted.");
            }
        } else {
            log.error("Cannot convert {} to Integer.", numberRequest);
        }
    }
}
