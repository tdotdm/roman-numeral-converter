package com.example.romannumeralconverter.core.domain;

public abstract class PlaceValue {
    private final Rank rank; //i.e. Thousands
    private final Integer value; //i.e. 3

    public PlaceValue(final Rank rank,
                      final Integer value) {
        this.rank = rank;
        this.value = value;
    }
}
