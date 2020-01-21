package com.example.romannumeralconverter.core;

import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
import com.example.romannumeralconverter.core.domain.request.RequestValidator;
import com.example.romannumeralconverter.core.domain.request.StringToIntegerConverter;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGenerator;
import com.example.romannumeralconverter.core.domain.romannumeral.RomanNumeralGeneratorImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void delegate_ShouldThrowException_WhenGivenEmptyString() {
        //given
        givenRequestFormatterReturnsEmptyOptional();
        final String input = "     ";

        //then
        assertExceptionThrown(input);
    }
}