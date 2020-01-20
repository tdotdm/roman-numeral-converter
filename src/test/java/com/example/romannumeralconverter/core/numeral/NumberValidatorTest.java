package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.configuration.ApplicationProperties;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberValidatorTest {
    /*
     * Test subject
     * */
    private final ApplicationProperties applicationProperties = newApplicationProperties(1, 3999);
    private final NumberValidator target = new NumberValidator(applicationProperties);

    /*
     * Util
     * */
    private ApplicationProperties newApplicationProperties(final int lowerBound,
                                                           final int upperBound) {
        final ApplicationProperties applicationProperties = new ApplicationProperties();
        applicationProperties.setLowerBound(lowerBound);
        applicationProperties.setUpperBound(upperBound);

        return applicationProperties;
    }

    @Test
    public void numberIsValid_ShouldReturnFalse_WhenGivenZero() {
        //given
        final int numberToConvert = 0;

        //when
        final boolean result = target.numberIsValid(numberToConvert);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void numberIsValid_ShouldReturnFalse_WhenLowerThanLowerBound() {
        //given
        final int numberToConvert = -1;

        //when
        final boolean result = target.numberIsValid(numberToConvert);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void numberIsValid_ShouldReturnFalse_WhenHigherThanHigherBound() {
        //given
        final int numberToConvert = 4000;

        //when
        final boolean result = target.numberIsValid(numberToConvert);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void numberIsValid_ShouldReturnTrue_WhenNotLowerThanLowerBound() {
        //given
        final int numberToConvert = 10;

        //when
        final boolean result = target.numberIsValid(numberToConvert);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void numberIsValid_ShouldReturnTrue_WhenNotHigherThanHigherBound() {
        //given
        final int numberToConvert = 3989;

        //when
        final boolean result = target.numberIsValid(numberToConvert);

        //then
        assertThat(result).isTrue();
    }
}