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
        final StringBuilder stringBuilder = new StringBuilder();
        final String cKey = RomanNumeral.C.getKey();
        final String dKey = RomanNumeral.D.getKey();
        final String mKey = RomanNumeral.M.getKey();

        if (this.value < 4) {
            for (int i = 0; i < this.value; i++) {
                stringBuilder.append(cKey);
            }
        } else if (this.value == 4) {
            stringBuilder.append(cKey);
            stringBuilder.append(dKey);
        } else if (this.value == 5) {
            stringBuilder.append(dKey);
        } else if (this.value == 6) {
            stringBuilder.append(dKey);
            stringBuilder.append(cKey);
        } else if (this.value == 7) {
            stringBuilder.append(dKey);
            stringBuilder.append(cKey);
            stringBuilder.append(cKey);
        } else if (this.value == 8) {
            stringBuilder.append(dKey);
            stringBuilder.append(cKey);
            stringBuilder.append(cKey);
            stringBuilder.append(cKey);
        } else if (this.value == 9) {
            stringBuilder.append(cKey);
            stringBuilder.append(mKey);
        } else if (this.value == 10) {
            stringBuilder.append(mKey);
        }

        return stringBuilder.toString();
    }
}
