package com.example.romannumeralconverter.core.domain.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class StringToIntegerConverter {
    public Optional<Integer> convert(final String numberToConvert) {
        try {
            final int inputAsInteger = Integer.parseInt(numberToConvert);
            return Optional.of(inputAsInteger);
        } catch (final NumberFormatException e) {
            return Optional.empty();
        }
    }
}
