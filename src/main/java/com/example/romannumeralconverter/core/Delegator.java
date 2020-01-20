package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.numeral.NumeralValidator;
import com.example.romannumeralconverter.core.numeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.numeral.RomanNumeralPrinter;
import com.example.romannumeralconverter.core.numeral.StringNumeralToIntegerNumeralConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class Delegator {
    private final StringNumeralToIntegerNumeralConverter stringNumeralToIntegerNumeralConverter;
    private final NumeralValidator numeralValidator;
    private final RomanNumeralGenerator romanNumeralGenerator;
    private final RomanNumeralPrinter romanNumeralPrinter;

    public void delegate(final String userInput) {
        final Optional<Integer> optionalNumberToConvert = stringNumeralToIntegerNumeralConverter.convert(userInput);
        if (optionalNumberToConvert.isPresent()) {
            final Integer numberToConvert = optionalNumberToConvert.get();
            final boolean numberIsValid = numeralValidator.numeralIsValid(numberToConvert);

            if (numberIsValid) {
                log.info("Converting {} to Roman numeral.", numberToConvert);
                final String romanNumeral = romanNumeralGenerator.generate(numberToConvert);
                romanNumeralPrinter.print(romanNumeral);
            } else {
                log.error("Number is not valid.");
            }
        } else {
            log.error("Cannot convert {} to Integer.", userInput);
        }
    }
}
