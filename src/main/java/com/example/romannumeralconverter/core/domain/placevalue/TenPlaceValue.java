package com.example.romannumeralconverter.core.domain.placevalue;

import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeral;

public class TenPlaceValue extends PlaceValue {
    protected TenPlaceValue(final Integer value) {
        super(Rank.TEN, value, RomanNumeral.X, RomanNumeral.L, RomanNumeral.C);
    }

    public static TenPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 10 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new TenPlaceValue(integerPlaceValue);
    }
}