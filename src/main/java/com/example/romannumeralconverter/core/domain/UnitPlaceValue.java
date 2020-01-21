package com.example.romannumeralconverter.core.domain;

public class UnitPlaceValue extends PlaceValue {
    protected UnitPlaceValue(final Integer value) {
        super(Rank.UNIT, value, RomanNumeral.I, RomanNumeral.V, RomanNumeral.X);
    }

    public static UnitPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert % 10);
        final int integerPlaceValue = (int) placeValue;

        return new UnitPlaceValue(integerPlaceValue);
    }
}
