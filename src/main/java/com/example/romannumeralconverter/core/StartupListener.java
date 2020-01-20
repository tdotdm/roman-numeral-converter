package com.example.romannumeralconverter.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {
    private final Delegator delegator;

    @Override
    public void run(final String... args) {
        delegator.delegate();
    }
}
