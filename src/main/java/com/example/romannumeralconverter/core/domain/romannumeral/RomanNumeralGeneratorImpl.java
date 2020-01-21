package com.example.romannumeralconverter.core.domain.romannumeral;

import com.example.romannumeralconverter.core.domain.placevalue.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    /*
     * From the given number,
     * generate and return
     * the appropriate Roman numeral.
     *
     * Note: this method will operate on
     * a number range of 1 - 3999, i.e. Standard notation.
     * */
    @Override
    public String generate(final int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Illegal number! The number cannot be expressed in Standard notation.");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        final int numberLength = String.valueOf(number).length();
        if (numberLength > 0) {
            final UnitPlaceValue unitPlaceValue = UnitPlaceValue.from(number);
            final String unitRomanNumeral = getRomanNumeral(unitPlaceValue);
            stringBuilder.insert(0, unitRomanNumeral);

            if (numberLength > 1) {
                final TenPlaceValue tenPlaceValue = TenPlaceValue.from(number);
                final String tenRomanNumeral = getRomanNumeral(tenPlaceValue);
                stringBuilder.insert(0, tenRomanNumeral);

                if (numberLength > 2) {
                    final HundredPlaceValue hundredPlaceValue = HundredPlaceValue.from(number);
                    final String hundredRomanNumeral = getRomanNumeral(hundredPlaceValue);
                    stringBuilder.insert(0, hundredRomanNumeral);

                    if (numberLength > 3) {
                        final ThousandPlaceValue thousandPlaceValue = ThousandPlaceValue.from(number);
                        final String thousandRomanNumeral = getRomanNumeral(thousandPlaceValue);
                        stringBuilder.insert(0, thousandRomanNumeral);
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    /*
     * The pattern for Roman numerals is identical across
     * all place values, which can therefore be
     * expressed through the following method.
     *
     * Note: when working with Thousand, the limit is
     * MMM but at this point in the application, the
     * User's input should be validated and rejected if
     * appropriate.
     * */
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
