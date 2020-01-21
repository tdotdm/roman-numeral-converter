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

    public String delegate(final String numberToConvert) throws ServiceException {
        final Optional<String> optionalFormattedNumberToConvert = requestFormatter.format(numberToConvert);
        if (optionalFormattedNumberToConvert.isEmpty()) {
            throw new ServiceException("Cannot format String.");
        }

        final String formattedNumberToConvert = optionalFormattedNumberToConvert.get();
        final Optional<Integer> optionalNumberToConvert = stringToIntegerConverter.convert(formattedNumberToConvert);
        if (optionalNumberToConvert.isEmpty()) {
            throw new ServiceException("Cannot convert String to Integer.");
        }

        final Integer number = optionalNumberToConvert.get();
        final boolean numberIsValid = requestValidator.numberIsValid(number);
        if (!numberIsValid) {
            throw new ServiceException("Integer is not valid.");
        }

        return romanNumeralGenerator.generate(number);
    }
}
