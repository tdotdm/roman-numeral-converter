package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.numeral.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class Delegator {
    private final ApplicationProperties applicationProperties;
    private final UserInputFormatter userInputFormatter;
    private final StringNumeralToIntegerNumeralConverter stringNumeralToIntegerNumeralConverter;
    private final NumeralValidator numeralValidator;
    private final RomanNumeralGenerator romanNumeralGenerator;
    private final RomanNumeralResultPrinter romanNumeralResultPrinter;

    public void delegate() {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final Optional<String> optionalFormattedUserInput = userInputFormatter.format(numberToConvert);
        if (optionalFormattedUserInput.isPresent()) {
            final String formattedUserInput = optionalFormattedUserInput.get();
            final Optional<Integer> optionalNumeral = stringNumeralToIntegerNumeralConverter.convert(formattedUserInput);
            if (optionalNumeral.isPresent()) {
                final Integer numeral = optionalNumeral.get();
                final boolean numeralIsValid = numeralValidator.numeralIsValid(numeral);

                if (numeralIsValid) {
                    log.info("Converting {} to Roman numeral.", numeral);
                    final String numeralAsRomanNumeral = romanNumeralGenerator.generate(numeral);
                    romanNumeralResultPrinter.print(numeralAsRomanNumeral);
                } else {
                    log.error("Number is not valid. ");
                }
            } else {
                log.error("Cannot convert User Input to Integer.");
            }
        } else {
            log.error("Cannot format User Input.");
        }
    }
}
