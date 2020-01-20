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
        final StringBuilder stringBuilder = new StringBuilder();
        final String xKey = RomanNumeral.X.getKey();
        final String lKey = RomanNumeral.L.getKey();
        final String cKey = RomanNumeral.C.getKey();

        if (this.value < 4) {
            for (int i = 0; i < this.value; i++) {
                stringBuilder.append(xKey);
            }
        } else if (this.value == 4) {
            stringBuilder.append(xKey);
            stringBuilder.append(lKey);
        } else if (this.value == 5) {
            stringBuilder.append(lKey);
        } else if (this.value == 6) {
            stringBuilder.append(lKey);
            stringBuilder.append(xKey);
        } else if (this.value == 7) {
            stringBuilder.append(lKey);
            stringBuilder.append(xKey);
            stringBuilder.append(xKey);
        } else if (this.value == 8) {
            stringBuilder.append(lKey);
            stringBuilder.append(xKey);
            stringBuilder.append(xKey);
            stringBuilder.append(xKey);
        } else if (this.value == 9) {
            stringBuilder.append(xKey);
            stringBuilder.append(cKey);
        } else if (this.value == 10) {
            stringBuilder.append(cKey);
        }

        return stringBuilder.toString();
    }
}
