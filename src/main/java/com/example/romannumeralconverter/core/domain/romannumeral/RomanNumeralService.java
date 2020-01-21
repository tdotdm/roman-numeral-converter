package com.example.romannumeralconverter.core.domain.romannumeral;

import com.example.romannumeralconverter.core.domain.placevalue.PlaceValue;

public interface RomanNumeralService {
    String getRomanNumeral(PlaceValue placeValue);
}
