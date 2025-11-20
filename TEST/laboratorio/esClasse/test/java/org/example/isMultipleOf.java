package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class isMultipleOf {

    static Stream<Arguments> Valori() {
        return Stream.of(
                arguments(1, 1, true),     // 1 è multiplo di 1
                arguments(4, 2, true),     // 4 è multiplo di 2
                arguments(6, 9, false),    // 6 non è multiplo di 9
                arguments(2, 2, true),     // 2 è multiplo di 2
                arguments(9, -3, true),    // 9 è multiplo di -3
                arguments(-9, 3, true),    // -9 è multiplo di 3
                arguments(-8, -4, true),   // -8 è multiplo di -4
                arguments(7, -2, false)    // 7 non è multiplo di -2
        );
    }

    @DisplayName("Test veri")
    @ParameterizedTest(name = "n{0}  k{1} → atteso: {2}")
    @MethodSource("Valori")
    public void isMultiplo(int n, int k, boolean result) {

        assertEquals(NumberUtils.isMultipleOf(n,k),result);

    }

    //GpT PART

    // --- Test separato per k == 0 (eccezione attesa) ---
    @DisplayName("Test isMultipleOf con k = 0 deve lanciare IllegalArgumentException")
    @Test
    void testIsMultipleOf_kZero_throwsException() {
        assertThrows(IllegalArgumentException.class, ()-> NumberUtils.isMultipleOf(4,0));
        assertThrows(IllegalArgumentException.class, ()-> NumberUtils.isMultipleOf(0,0));
        assertThrows(IllegalArgumentException.class, ()-> NumberUtils.isMultipleOf(-4,0));
    }
}
