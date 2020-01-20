package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {
    @Override
    public String generate(final int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot convert number to Roman numeral!");
        }

        final List<PlaceValue> placeValues = new ArrayList<>();
        final int numberLength = String.valueOf(number).length();
        if (numberLength > 3) {
            final PlaceValue placeValue = ThousandPlaceValue.from(number);
            placeValues.add(placeValue);
        }

        if (numberLength > 2) {
            final PlaceValue placeValue = HundredPlaceValue.from(number);
            placeValues.add(placeValue);
        }

        if (numberLength > 1) {
            final PlaceValue placeValue = TenPlaceValue.from(number);
            placeValues.add(placeValue);
        }

        if (numberLength > 0) {
            final PlaceValue placeValue = UnitPlaceValue.from(number);
            placeValues.add(placeValue);
        }

        return "todo";
    }
}
