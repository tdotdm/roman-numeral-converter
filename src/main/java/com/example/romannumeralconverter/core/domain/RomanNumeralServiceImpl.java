package com.example.romannumeralconverter.core.domain;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralServiceImpl implements RomanNumeralService {

    @Override
    public String getRomanNumeral(final PlaceValue placeValue) {
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
