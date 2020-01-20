package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.numeral.NumeralValidator;
import com.example.romannumeralconverter.core.numeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.numeral.StringNumeralToIntegerNumeralConverter;
import com.example.romannumeralconverter.core.numeral.UserInputFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {
    private final ApplicationProperties applicationProperties;
    private final UserInputFormatter userInputFormatter;
    private final StringNumeralToIntegerNumeralConverter stringNumeralToIntegerNumeralConverter;
    private final NumeralValidator numeralValidator;
    private final RomanNumeralGenerator romanNumeralGenerator;

    @Override
    public void run(final String... args) {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final String formattedNumberToConvert = userInputFormatter.format(numberToConvert);
        final Optional<Integer> optionalNumeral = stringNumeralToIntegerNumeralConverter.convert(formattedNumberToConvert);

        if (optionalNumeral.isPresent()) {
            final Integer numeral = optionalNumeral.get();
            final boolean numeralIsValid = numeralValidator.numeralIsValid(numeral);

            if (numeralIsValid) {
                log.info("Converting {} to Roman numeral.", numeral);
                final String numeralAsRomanNumeral = romanNumeralGenerator.generate(numeral);
                log.info("******************************");
                log.info("{} is '{}' in Roman numerals.", numeral, numeralAsRomanNumeral);
                log.info("******************************");
            } else {
                log.error("Number is not valid. ");
            }
        } else {
            log.error("Cannot convert {} to Integer.", formattedNumberToConvert);
        }
    }
}
