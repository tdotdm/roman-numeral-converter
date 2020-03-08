package com.github.tdotdm.core;

import com.github.tdotdm.core.configuration.ApplicationProperties;
import com.github.tdotdm.core.util.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {
    private final ApplicationProperties applicationProperties;
    private final Delegator delegator;

    @Override
    public void run(final String... args) {
        try {
            final String numberToConvert = applicationProperties.getNumberToConvert();
            final String convertedNumberAsRomanNumeral = delegator.delegate(numberToConvert);
            log.info("*************************");
            log.info("'{}' is '{}' in Roman numerals.", numberToConvert, convertedNumberAsRomanNumeral);
            log.info("*************************");
        } catch (final ServiceException e) {
            log.error("An error occurred: ", e);
        }
    }
}
