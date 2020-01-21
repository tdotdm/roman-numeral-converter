package com.example.romannumeralconverter.core.domain.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class StringToIntegerConverter {
    public Optional<Integer> convert(final String input) {
        log.info("Converting {} from String to Integer.", input);

        try {
            final int inputAsInteger = Integer.parseInt(input);
            return Optional.of(inputAsInteger);
        } catch (final NumberFormatException e) {
            log.error("Failed to convert input to an Integer. Are you sure {} is correct?", input);
            return Optional.empty();
        }
    }
}
