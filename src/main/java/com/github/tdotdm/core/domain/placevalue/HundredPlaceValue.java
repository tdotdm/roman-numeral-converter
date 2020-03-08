package com.github.tdotdm.core.domain.placevalue;

import com.github.tdotdm.core.domain.romannumeral.RomanNumeral;

public class HundredPlaceValue extends PlaceValue {
    protected HundredPlaceValue(final Integer value) {
        super(Rank.HUNDRED, value, RomanNumeral.C, RomanNumeral.D, RomanNumeral.M);
    }

    public static HundredPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 100 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new HundredPlaceValue(integerPlaceValue);
    }
}
