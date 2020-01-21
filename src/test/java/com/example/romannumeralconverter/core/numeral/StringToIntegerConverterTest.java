package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.domain.request.StringToIntegerConverter;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StringToIntegerConverterTest {
    /*
     * Test subject.
     * */
    private final StringToIntegerConverter target = new StringToIntegerConverter();

    @Test
    public void convert_ShouldReturnOptional_WhenGivenValidInteger() {
        //given
        final String input = "001";

        //when
        final Optional<Integer> result = target.convert(input);

        //then
        assertThat(result).isNotEmpty();
    }

    @Test
    public void convert_ShouldReturnEmptyOptional_WhenGivenInvalidInteger() {
        //given
        final String input = "ZeroZeroOne";

        //when
        final Optional<Integer> result = target.convert(input);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void convert_ShouldReturnIntegerMatchingInput_WhenGivenValidInteger() {
        //given
        final String input = "001";
        final Integer output = 1;

        //when
        final Optional<Integer> optionalResult = target.convert(input);
        final Integer result = optionalResult.get();

        //then
        assertThat(result).isEqualTo(output);
    }
}