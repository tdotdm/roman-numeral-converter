package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    private final RomanNumeralServiceImpl romanNumeralServiceImpl;

    @Override
    public String generate(final int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot convert number to Roman numeral!");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        final int numberLength = String.valueOf(number).length();
        if (numberLength > 3) {
            final ThousandPlaceValue placeValue = ThousandPlaceValue.from(number);
            final String romanNumeral = romanNumeralServiceImpl.getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 2) {
            final HundredPlaceValue placeValue = HundredPlaceValue.from(number);
            final String romanNumeral = romanNumeralServiceImpl.getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 1) {
            final TenPlaceValue placeValue = TenPlaceValue.from(number);
            final String romanNumeral = romanNumeralServiceImpl.getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 0) {
            final UnitPlaceValue placeValue = UnitPlaceValue.from(number);
            final String romanNumeral = romanNumeralServiceImpl.getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        final String romanNumeral = stringBuilder.toString();
        return romanNumeral;
    }
}
