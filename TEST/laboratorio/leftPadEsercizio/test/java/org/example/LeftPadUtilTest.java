package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LeftPadUtilTest {

    static Stream<Arguments> valori() {
        return Stream.of(
                Arguments.of(null, 1, "s", null),
                Arguments.of("", 1, "s", "s"),
                Arguments.of("string", 1, "string", "string"),
                Arguments.of("string", 6, "string", "string"),
                Arguments.of("s", 2, "x", "xs"),
                Arguments.of("s", 2, null, " s"),
                Arguments.of("s", 2, "", " s"),
                Arguments.of("string", -1, "x", "string"),
                Arguments.of("string", 0, "x", "string"),
                // Nuovi test aggiunti
                Arguments.of("s", 3, "xyz", "xys"),
                Arguments.of("s", 2, "x", "xs"),//gia fatto
                Arguments.of("s", 3, "x", "xxs")
        );
    }

    @ParameterizedTest(name="{index} str={0},size={1},padStr={2}     valore atteso={3}")
    @MethodSource("valori")
    public void testLeftPad(String str, int size, String padStr, String expected) {
        if (str == null) {
            assertNull(LeftPadUtil.leftPad(str, size, padStr));
        } else {
            assertEquals(expected, LeftPadUtil.leftPad(str, size, padStr));
        }
    }
}
