package com.example.romannumeralconverter.core.domain;

public class TenPlaceValue extends PlaceValue {
    protected TenPlaceValue(final Integer value) {
        super(Rank.TEN, value);
    }

    public static TenPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 10 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new TenPlaceValue(integerPlaceValue);
    }

    @Override
    public String getRomanNumeral() {
        return null;
    }
}
