package com.github.tdotdm.core.domain.placevalue;

import com.github.tdotdm.core.domain.romannumeral.RomanNumeral;

public class ThousandPlaceValue extends PlaceValue {
    protected ThousandPlaceValue(final Integer value) {
        super(Rank.THOUSAND, value, RomanNumeral.M, null, null);
    }

    public static ThousandPlaceValue from(final Integer numberToConvert) {
        final double placeValue = Math.floor(numberToConvert / 1000 % 10);
        final int integerPlaceValue = (int) placeValue;

        return new ThousandPlaceValue(integerPlaceValue);
    }
}
