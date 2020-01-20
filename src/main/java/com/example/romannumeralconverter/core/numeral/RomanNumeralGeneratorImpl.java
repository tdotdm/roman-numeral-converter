package com.example.romannumeralconverter.core.numeral;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    @Override
    public String generate(final int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot convert number to Roman numeral!");
        }

        return null;
    }
}
