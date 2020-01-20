package com.example.romannumeralconverter.core.domain;

public class UnitPlaceValue extends PlaceValue {
    protected UnitPlaceValue(final Integer value) {
        super(Rank.UNIT, value);
    }

    public static UnitPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert % 10);
        final int integerPlaceValue = (int) placeValue;

        return new UnitPlaceValue(integerPlaceValue);
    }

    @Override
    public String getRomanNumeral() {
        final StringBuilder stringBuilder = new StringBuilder();
        final String iKey = RomanNumeral.I.getKey();
        final String vKey = RomanNumeral.V.getKey();
        final String xKey = RomanNumeral.X.getKey();

        if (this.value < 4) {
            for (int i = 0; i < this.value; i++) {
                stringBuilder.append(iKey);
            }
        } else if (this.value == 4) {
            stringBuilder.append(iKey);
            stringBuilder.append(vKey);
        } else if (this.value == 5) {
            stringBuilder.append(vKey);
        } else if (this.value == 6) {
            stringBuilder.append(vKey);
            stringBuilder.append(iKey);
        } else if (this.value == 7) {
            stringBuilder.append(vKey);
            stringBuilder.append(iKey);
            stringBuilder.append(iKey);
        } else if (this.value == 8) {
            stringBuilder.append(vKey);
            stringBuilder.append(iKey);
            stringBuilder.append(iKey);
            stringBuilder.append(iKey);
        } else if (this.value == 9) {
            stringBuilder.append(iKey);
            stringBuilder.append(xKey);
        } else if (this.value == 10) {
            stringBuilder.append(xKey);
        }

        return stringBuilder.toString();
    }
}
