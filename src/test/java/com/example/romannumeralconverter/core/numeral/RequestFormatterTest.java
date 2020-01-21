package com.example.romannumeralconverter.core.numeral;

import com.example.romannumeralconverter.core.domain.request.RequestFormatter;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RequestFormatterTest {
    /*
     * Test subject.
     * */
    private final RequestFormatter target = new RequestFormatter();

    @Test
    public void format_ShouldReturnEmptyOptional_WhenGivenNull() {
        //given
        final String input = null;
        //when
        final Optional<String> result = target.format(input);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void format_ShouldReturnEmptyOptional_WhenGivenEmptyInput() {
        //given
        final String input = "     ";
        //when
        final Optional<String> result = target.format(input);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void format_ShouldRemoveStartingZeroes_WhenGivenValidInput() {
        //given
        final String input = "00000test";
        final String output = "test";

        //when
        final Optional<String> optionalResult = target.format(input);
        final String result = optionalResult.get();

        //then
        assertThat(result).isEqualTo(output);
    }

    @Test
    public void format_ShouldNotChangeInput_WhenGivenInputWithNoStartingZeroes() {
        //given
        final String input = "test";
        final String output = "test";

        //when
        final Optional<String> optionalResult = target.format(input);
        final String result = optionalResult.get();

        //then
        assertThat(result).isEqualTo(output);
    }
}