package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.numeral.NumeralFormatter;
import com.example.romannumeralconverter.core.numeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.numeral.StringNumeralToIntegerNumeralConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {
    private final ApplicationProperties applicationProperties;
    private final NumeralFormatter numeralFormatter;
    private final StringNumeralToIntegerNumeralConverter stringNumeralToIntegerNumeralConverter;
    private final RomanNumeralGenerator romanNumeralGenerator;

    @Override
    public void run(final String... args) {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final String formattedNumberToConvert = numeralFormatter.format(numberToConvert);
        stringNumeralToIntegerNumeralConverter
                .convert(formattedNumberToConvert)
                .ifPresentOrElse(numeral -> {
                    log.info("Converting {} to Roman Numeral.", numeral);
                    final String numeralAsRomanNumeral = romanNumeralGenerator.generate(numeral);
                    log.info("******************************");
                    log.info("{} is {} in Roman numerals.", numeral, numeralAsRomanNumeral);
                    log.info("******************************");
                }, () -> log.error("Application shutting down - cannot convert to Roman Numeral."));
    }
}
