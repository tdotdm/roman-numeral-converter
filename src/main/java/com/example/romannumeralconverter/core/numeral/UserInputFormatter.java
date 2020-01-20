package com.example.romannumeralconverter.core.numeral;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserInputFormatter {
    private static final String LEADING_ZEROES = "^0+(?!$)";

    public Optional<String> format(final String numeral) {
        if (numeral.isEmpty()) {
            log.error("No valid User Input to format.");
            return Optional.empty();
        }

        log.info("Formatting User Input.");
        final String formattedUserInput = numeral.replaceFirst(LEADING_ZEROES, "");
        return Optional.of(formattedUserInput);
    }
}
