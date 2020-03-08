package com.github.tdotdm.core.domain.placevalue;

import com.github.tdotdm.core.domain.romannumeral.RomanNumeral;

public abstract class PlaceValue {
    protected final Rank rank; //i.e. Thousands
    protected final Integer value; //i.e. 3
    protected final RomanNumeral lowerKey; //i.e. I
    protected final RomanNumeral middleKey; //i.e. V
    protected final RomanNumeral upperKey; //i.e. X

    public PlaceValue(final Rank rank,
                      final Integer value,
                      final RomanNumeral lowerKey,
                      final RomanNumeral middleKey,
                      final RomanNumeral upperKey) {
        this.rank = rank;
        this.value = value;
        this.lowerKey = lowerKey;
        this.middleKey = middleKey;
        this.upperKey = upperKey;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getLowerKey() {
        if (this.lowerKey != null) {
            return this.lowerKey.getKey();
        }

        return null;
    }

    public String getMiddleKey() {
        if (this.middleKey != null) {
            return this.middleKey.getKey();
        }

        return null;
    }

    public String getUpperKey() {
        if (this.upperKey != null) {
            return this.upperKey.getKey();
        }

        return null;
    }
}
