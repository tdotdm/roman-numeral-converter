package com.example.romannumeralconverter.core.domain;

public class HundredPlaceValue extends PlaceValue {
    protected HundredPlaceValue(final Integer value) {
        super(Rank.HUNDRED, value);
    }

    public static HundredPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 100 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new HundredPlaceValue(integerPlaceValue);
    }

    @Override
    public String getRomanNumeral() {
        return null;
    }
}
