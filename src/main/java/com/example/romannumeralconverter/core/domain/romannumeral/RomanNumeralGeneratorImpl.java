package com.example.romannumeralconverter.core.domain.romannumeral;

import com.example.romannumeralconverter.core.domain.placevalue.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    @Override
    public String generate(final int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot convert number to Roman numeral!");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        final int numberLength = String.valueOf(number).length();
        if (numberLength > 3) {
            final ThousandPlaceValue placeValue = ThousandPlaceValue.from(number);
            final String romanNumeral = getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 2) {
            final HundredPlaceValue placeValue = HundredPlaceValue.from(number);
            final String romanNumeral = getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 1) {
            final TenPlaceValue placeValue = TenPlaceValue.from(number);
            final String romanNumeral = getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        if (numberLength > 0) {
            final UnitPlaceValue placeValue = UnitPlaceValue.from(number);
            final String romanNumeral = getRomanNumeral(placeValue);
            stringBuilder.append(romanNumeral);
        }

        return stringBuilder.toString();
    }

    private String getRomanNumeral(final PlaceValue placeValue) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String lowerKey = placeValue.getLowerKey(); //lowerKey i.e. I,
        final String middleKey = placeValue.getMiddleKey(); //middleKey i.e. V,
        final String upperKey = placeValue.getUpperKey(); //upperKey i.e. X
        final Integer value = placeValue.getValue();

        if (value < 4) {
            for (int i = 0; i < value; i++) {
                stringBuilder.append(lowerKey);
            }
        } else if (value == 4) {
            stringBuilder.append(lowerKey);
            stringBuilder.append(middleKey);
        } else if (value == 5) {
            stringBuilder.append(middleKey);
        } else if (value == 6) {
            stringBuilder.append(middleKey);
            stringBuilder.append(lowerKey);
        } else if (value == 7) {
            stringBuilder.append(middleKey);
            stringBuilder.append(lowerKey);
            stringBuilder.append(lowerKey);
        } else if (value == 8) {
            stringBuilder.append(middleKey);
            stringBuilder.append(lowerKey);
            stringBuilder.append(lowerKey);
            stringBuilder.append(lowerKey);
        } else if (value == 9) {
            stringBuilder.append(lowerKey);
            stringBuilder.append(upperKey);
        } else if (value == 10) {
            stringBuilder.append(upperKey);
        }

        return stringBuilder.toString();
    }
}
