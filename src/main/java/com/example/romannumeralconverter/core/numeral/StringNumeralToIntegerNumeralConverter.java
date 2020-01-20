package com.example.romannumeralconverter.core.numeral;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class StringNumeralToIntegerNumeralConverter {
    public Optional<Integer> convert(final String numeral) {
        log.info("Converting {} from String to Integer.", numeral);

        try {
            final int numeralAsInteger = Integer.parseInt(numeral);
            return Optional.of(numeralAsInteger);
        } catch (final NumberFormatException e) {
            log.error("Failed to convert numeral to an Integer. Are you sure {} is correct?", numeral);
            return Optional.empty();
        }
    }
}
