package com.example.romannumeralconverter.core.domain.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RequestFormatter {
    private static final String LEADING_ZEROES = "^0+(?!$)";

    public Optional<String> format(final String userInput) {
        if (userInput == null || userInput.isBlank()) {
            log.error("No valid User Input to format.");
            return Optional.empty();
        }

        log.info("Formatting User Input.");
        final String formattedUserInput = userInput.replaceFirst(LEADING_ZEROES, "");
        return Optional.of(formattedUserInput);
    }
}
