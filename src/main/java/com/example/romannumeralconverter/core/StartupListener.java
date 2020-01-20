package com.example.romannumeralconverter.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupListener implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        log.info("Hello, world!");
    }
}
