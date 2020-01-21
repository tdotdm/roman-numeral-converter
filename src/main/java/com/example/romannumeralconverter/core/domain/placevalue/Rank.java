package com.example.romannumeralconverter.core.domain.placevalue;

public enum Rank {
    THOUSAND("Thousands"),
    HUNDRED("Hundreds"),
    TEN("Tens"),
    UNIT("Units");

    private final String value;

    private Rank(final String value) {
        this.value = value;
    }
}
