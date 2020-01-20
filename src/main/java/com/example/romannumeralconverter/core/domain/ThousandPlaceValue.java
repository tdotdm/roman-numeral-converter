package com.example.romannumeralconverter.core.domain;

public class ThousandPlaceValue extends PlaceValue {
    protected ThousandPlaceValue(final Integer value) {
        super(Rank.THOUSAND, value);
    }

    public static ThousandPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 1000 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new ThousandPlaceValue(integerPlaceValue);
    }

    @Override
    public String getRomanNumeral() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.value; i++) {
            stringBuilder.append(RomanNumeral.M.getKey());
        }

        return stringBuilder.toString();
    }
}
