package com.example.romannumeralconverter.core.numeral;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RomanNumeralPrinterImpl implements RomanNumeralPrinter {
    @Override
    public void print(final String romanNumeral) {
        log.info("******************************");
        log.info(romanNumeral);
        log.info("******************************");
    }
}
