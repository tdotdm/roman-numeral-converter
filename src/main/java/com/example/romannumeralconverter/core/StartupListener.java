package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import com.example.romannumeralconverter.core.numeral.UserInputFormatter;
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
    private final UserInputFormatter userInputFormatter;
    private final Delegator delegator;

    @Override
    public void run(final String... args) {
        final String numberToConvert = applicationProperties.getNumberToConvert();
        final Optional<String> optionalFormattedUserInput = userInputFormatter.format(numberToConvert);

        if (optionalFormattedUserInput.isPresent()) {
            final String userInput = optionalFormattedUserInput.get();
            delegator.delegate(userInput);
        }
    }
}
