package com.example.romannumeralconverter.core.domain.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RequestFormatter {
    private static final String LEADING_ZEROES = "^0+(?!$)";

    /*
     * Format the User's input by
     * removing all leading zeroes.
     * For example, 007 will become 7.
     * */
    public Optional<String> format(final String numberToConvert) {
        if (numberToConvert == null || numberToConvert.isBlank()) {
            return Optional.empty();
        }

        final String formattedUserInput = numberToConvert.replaceFirst(LEADING_ZEROES, "");
        return Optional.of(formattedUserInput);
    }
}
