package com.example.romannumeralconverter.core.domain;

import lombok.Getter;

@Getter
public enum RomanNumeral {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    private final String key;
    private final Integer value;

    private RomanNumeral(final String key,
                         final int value) {
        this.key = key;
        this.value = value;
    }
}
