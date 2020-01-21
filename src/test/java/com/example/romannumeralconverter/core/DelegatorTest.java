package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
import com.example.romannumeralconverter.core.domain.request.RequestValidator;
import com.example.romannumeralconverter.core.util.StringToIntegerConverter;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGeneratorImpl;
import com.example.romannumeralconverter.core.util.ServiceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    private void assertExceptionThrown(final String input) {
        //then
        Assertions.assertThatThrownBy(() -> {
            target.delegate(input);
        }).isInstanceOf(ServiceException.class);
    }

    private void givenRequestFormatterReturnsEmptyOptional() {
        //given
        when(requestFormatter.format(any())).thenReturn(Optional.empty());
    }

    private void givenRequestFormatterReturnsOptional(final String input) {
        //given
        when(requestFormatter.format(any())).thenReturn(Optional.of(input));
    }

    private void givenStringToIntegerConverterReturnsEmptyOptional() {
        //given
        when(stringToIntegerConverter.convert(any())).thenReturn(Optional.empty());
    }

    private void givenStringToIntegerConverterReturnsOptional(final int input) {
        //given
        when(stringToIntegerConverter.convert(any())).thenReturn(Optional.of(input));
    }

    private void givenRequestValidatorReturns(final boolean input) {
        //given
        when(requestValidator.validate(anyInt())).thenReturn(input);
    }

    private void givenRomanNumeralGeneratorReturns(final String result) {
        //given
        when(romanNumeralGenerator.generate(anyInt())).thenReturn(result);
    }

    @Test
    public void delegate_ShouldThrowException_WhenGivenEmptyString() {
        //given
        final String input = "     ";
        givenRequestFormatterReturnsEmptyOptional();

        //then
        assertExceptionThrown(input);
    }

    @Test
    public void delegate_ShouldThrowException_WhenGivenStringThatCantBeInteger() {
        //given
        final String input = "test_data";
        givenRequestFormatterReturnsOptional(input);
        givenStringToIntegerConverterReturnsEmptyOptional();

        //then
        assertExceptionThrown(input);
    }

    @Test
    public void delegate_ShouldThrowException_WhenGivenIntegerIsOutOfRange() {
        //given
        final String input = "4000";
        givenRequestFormatterReturnsOptional(input);
        givenStringToIntegerConverterReturnsOptional(4000);
        givenRequestValidatorReturns(false);

        //then
        assertExceptionThrown(input);
    }

    @Test
    public void delegate_ShouldReturnRomanNumeral_WhenGivenInputIsValid() throws ServiceException {
        //given
        final String input = "3999";
        final String output = "MMMCMXCIX";

        givenRequestFormatterReturnsOptional(input);
        givenStringToIntegerConverterReturnsOptional(3999);
        givenRequestValidatorReturns(true);
        givenRomanNumeralGeneratorReturns(output);

        //when
        final String result = target.delegate(input);

        //then
        assertThat(result).isEqualTo(output);
    }
}