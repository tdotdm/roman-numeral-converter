package com.example.romannumeralconverter.core.domain.romannumeral;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void generate_ShouldReturnExpectedStrings_WhenGivenUnits() {
        //given
        final List<Integer> inputs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<String> outputs = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        //when
        final int inputsSize = inputs.size();
        for (int x = 0; x < inputsSize; x++) {
            final String result = target.generate(inputs.get(x));
            final String expectedResult = outputs.get(x);

            //then
            assertThat(result).isEqualTo(expectedResult);
        }
    }

    @Test
    public void generate_ShouldReturnExpectedStrings_WhenGivenTens() {
        //given
        final List<Integer> inputs = List.of(10, 21, 32, 43, 54, 65, 76, 87, 98, 99);
        final List<String> outputs = List.of(
                "X",
                "XXI",
                "XXXII",
                "XLIII",
                "LIV",
                "LXV",
                "LXXVI",
                "LXXXVII",
                "XCVIII",
                "XCIX"
        );

        //when
        final int inputsSize = inputs.size();
        for (int x = 0; x < inputsSize; x++) {
            final String result = target.generate(inputs.get(x));
            final String expectedResult = outputs.get(x);

            //then
            assertThat(result).isEqualTo(expectedResult);
        }
    }
}