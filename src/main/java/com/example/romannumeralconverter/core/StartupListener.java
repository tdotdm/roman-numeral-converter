package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.domain.numberrequest.NumberRequestFormatter;
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
    private final NumberRequestFormatter numberRequestFormatter;
    private final Delegator delegator;

    @Override
    public void run(final String... args) {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final Optional<String> optionalFormattedUserInput = numberRequestFormatter.format(numberToConvert);

        if (optionalFormattedUserInput.isPresent()) {
            final String userInput = optionalFormattedUserInput.get();
            delegator.delegate(userInput);
        }
    }
}
