package com.example.romannumeralconverter.core.domain.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RequestFormatter {
    private static final String LEADING_ZEROES = "^0+(?!$)";

    public Optional<String> format(final String request) {
        if (request == null || request.isBlank()) {
            return Optional.empty();
        }

        final String formattedUserInput = request.replaceFirst(LEADING_ZEROES, "");
        return Optional.of(formattedUserInput);
    }
}
