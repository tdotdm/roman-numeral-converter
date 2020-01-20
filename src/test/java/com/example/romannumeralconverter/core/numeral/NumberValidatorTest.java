package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class NumberValidatorTest {
    /*
     * Target
     * */
    private final ApplicationProperties applicationProperties = mock(ApplicationProperties.class);
    private final NumberValidator target = new NumberValidator(applicationProperties);

    @Test
    public void testName() {
        //ignore
    }
}