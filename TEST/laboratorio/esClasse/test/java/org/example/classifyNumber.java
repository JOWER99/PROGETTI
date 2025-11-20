package org.example;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class classifyNumber {

    static Stream<Integer> oddNumbersProvider() {
        return Stream.of(-7, -3, 3, 5, 101, Integer.MAX_VALUE);
    }

    static Stream<Arguments> valoriEstremi() {
        return Stream.of(
                // Integer.MAX_VALUE è dispari
                Arguments.of(Integer.MAX_VALUE, "DISPARI"),
                // Integer.MIN_VALUE è pari
                Arguments.of(Integer.MIN_VALUE, "PARI")
        );
    }


    // Parte 1: CsvSource (tabella inline)

    @DisplayName("classifyNumber() - casi da CsvSource (0, pari, dispari; positivi/negativi)")
    @ParameterizedTest(name = "Input {0} → atteso: {1}")
    @CsvSource({
            // zero
            "0, ZERO",
            // pari positivi/negativi
            "2, PARI",
            "-2, PARI",
            "10, PARI",
            // dispari positivi/negativi
            "1, DISPARI",
            "-1, DISPARI",
            "7, DISPARI"
    })
    void testClassifyNumberWithCsvSource(int input, String atteso) {
        assertEquals(atteso, NumberUtils.classifyNumber(input));
    }

    // Parte 2: MethodSource (casi limite/particolari)

    @DisplayName("classifyNumber() - casi estremi con MethodSource")
    @ParameterizedTest(name = "Input {0} → atteso: {1}")
    @MethodSource("valoriEstremi")
    void testClassifyNumberExtreme(int input, String atteso) {
        assertEquals(atteso, NumberUtils.classifyNumber(input));
    }

    // parte prof
    @DisplayName("test pari")
    @ParameterizedTest(name = "[{index}] n={0} è PARI")
    @ValueSource(ints = { -4, -100, 6, 1000, Integer.MIN_VALUE })
    void even_numbers_withValueSource(int n) {
        assertEquals("PARI", NumberUtils.classifyNumber(n));
    }

    @DisplayName("Tutti questi valori sono DISPARI (MethodSource)")
    @ParameterizedTest(name = "[{index}] n={0} è DISPARI")
    @MethodSource("oddNumbersProvider")
    void odd_numbers_withMethodSource(int n) {
        assertEquals( "DISPARI", NumberUtils.classifyNumber(n));
    }
}