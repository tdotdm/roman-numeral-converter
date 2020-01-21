package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
import com.example.romannumeralconverter.core.domain.request.RequestValidator;
import com.example.romannumeralconverter.core.domain.request.StringToIntegerConverter;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGeneratorImpl;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class DelegatorTest {
    /*
     * Test subject.
     * */
    private final StringToIntegerConverter stringToIntegerConverter = mock(StringToIntegerConverter.class);
    private final RequestFormatter requestFormatter = mock(RequestFormatter.class);
    private final RequestValidator requestValidator = mock(RequestValidator.class);
    private final RomanNumeralGenerator romanNumeralGenerator = mock(RomanNumeralGeneratorImpl.class);
    private final Delegator target = new Delegator(
            stringToIntegerConverter,
            requestFormatter,
            requestValidator,
            romanNumeralGenerator
    );

    @Test
    public void testName() {
        //given
        //when
        //then
    }
}