package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
import com.example.romannumeralconverter.core.domain.request.RequestValidator;
import com.example.romannumeralconverter.core.domain.request.StringToIntegerConverter;
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
    private final RequestFormatter requestFormatter;
    private final RequestValidator requestValidator;
    private final RomanNumeralGenerator romanNumeralGenerator;

    /*
     * Take the input from the User,
     * and carry out various actions/checks
     * before finally converting the User's
     * input to Roman numeral format.
     * */
    public String delegate(final String numberToConvert) throws ServiceException {
        log.info("Application will attempt to convert '{}' to Roman numerals.", numberToConvert);
        final Optional<String> optionalFormattedNumberToConvert = requestFormatter.format(numberToConvert);
        if (optionalFormattedNumberToConvert.isEmpty()) {
            log.error("An error occurred whilst formatting String.");
            throw new ServiceException("Cannot format String.");
        }

        final String formattedNumberToConvert = optionalFormattedNumberToConvert.get();
        final Optional<Integer> optionalNumberToConvert = stringToIntegerConverter.convert(formattedNumberToConvert);
        if (optionalNumberToConvert.isEmpty()) {
            log.error("An error occurred whilst converting formatted String to Integer.");
            throw new ServiceException("Cannot convert String to Integer.");
        }

        final int number = optionalNumberToConvert.get();
        final boolean numberIsValid = requestValidator.validate(number);
        if (!numberIsValid) {
            log.error("Integer is not valid - are you sure it is within the lower and upper boundary?");
            throw new ServiceException("Integer is not valid.");
        }

        return romanNumeralGenerator.generate(number);
    }
}
