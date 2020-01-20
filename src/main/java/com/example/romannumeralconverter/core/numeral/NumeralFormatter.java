package com.example.romannumeralconverter.core.numeral;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NumeralFormatter {
    private static final String LEADING_ZEROES = "^0+(?!$)";

    public String format(final String numeral) {
        log.info("Removing leading zeroes from numeral.");
        
        return numeral.replaceFirst(LEADING_ZEROES, "");
    }
}
