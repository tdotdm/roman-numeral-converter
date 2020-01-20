package com.example.romannumeralconverter.core.domain;

public abstract class PlaceValue {
    protected final Rank rank; //i.e. Thousands
    protected final Integer value; //i.e. 3

    public PlaceValue(final Rank rank,
                      final Integer value) {
        this.rank = rank;
        this.value = value;
    }
}
