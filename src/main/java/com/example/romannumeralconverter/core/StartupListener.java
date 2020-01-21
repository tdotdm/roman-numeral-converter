package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
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
    private final RequestFormatter requestFormatter;
    private final Delegator delegator;

    @Override
    public void run(final String... args) {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final Optional<String> optionalFormattedUserInput = requestFormatter.format(numberToConvert);

        if (optionalFormattedUserInput.isPresent()) {
            final String userInput = optionalFormattedUserInput.get();
            delegator.delegate(userInput);
        }
    }
}
