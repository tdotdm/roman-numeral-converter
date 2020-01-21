package com.example.romannumeralconverter.core.domain.romannumeral;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RomanNumeralGeneratorImplTest {
    /*
     * Test subject.
     * */
    private final RomanNumeralGeneratorImpl target = new RomanNumeralGeneratorImpl();

    @Test
    public void generate_ShouldThrowException_WhenGivenZero() {
        //given
        final int input = 0;

        //then
        assertThatThrownBy(() -> {
            target.generate(input);
        });
    }
}