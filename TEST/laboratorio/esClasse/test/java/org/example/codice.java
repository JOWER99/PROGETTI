package org.example;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Aggiungi questa annotazione per l'ordine dei test
public class codice {

    // Metodo di Setup: eseguito una sola volta prima di tutti i test
    @BeforeAll
    static void setup() {
        System.out.println("Eseguito prima di tutti i test\n");
    }

    // Metodo di Setup: eseguito prima di ogni test
    @BeforeEach
    void beforeEachTest() {
        System.out.println("\nEseguito prima di ogni test");
    }

    // Metodo di Teardown: eseguito una sola volta dopo che tutti i test sono stati eseguiti
    @AfterAll
    static void teardown() {
        System.out.println("Eseguito dopo tutti i test");
    }

    // Metodo di Teardown: eseguito dopo ogni test
    @AfterEach
    void afterEachTest() {
        System.out.println("Eseguito dopo ogni test");
    }

    // Metodo di Test: test che verifica un comportamento specifico
    @Test
    @Order(1)
    void testVerificaVero() {
        System.out.println("Eseguito test: testVerificaVero, Ordine: 1");
        boolean a = true;
        Assertions.assertTrue(a);  // Il test passa se a è true
    }

    // Metodo di Test: test che confronta un valore booleano
    @Test
    @Order(2)
    void testVerificaFalso() {
        System.out.println("Eseguito test: testVerificaFalso, Ordine: 2");
        boolean a = false;
        Assertions.assertFalse(a);  // Il test passa se a è false
    }

    // Metodo di Test: test che verifica se due valori sono uguali
    @Test
    @Order(3)
    void testVerificaUguali() {
        System.out.println("Eseguito test: testVerificaUguali, Ordine: 3");
        int a = 5;
        int b = 5;
        Assertions.assertEquals(a, b, "I valori non sono uguali!");  // Il test passa se a == b
    }

    // Metodo di Test: test che verifica l'eccezione
    @Test
    @Order(4)
    void testVerificaEccezione() {
        System.out.println("Eseguito test: testVerificaEccezione, Ordine: 4");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Errore!");  // Il test passa se viene lanciata IllegalArgumentException
        });
    }

    // Metodo di Test: test che verifica che un oggetto non sia null
    @Test
    @Order(5)
    void testVerificaNonNull() {
        System.out.println("Eseguito test: testVerificaNonNull, Ordine: 5");
        String str = "JUnit";
        Assertions.assertNotNull(str);  // Il test passa se str non è null
    }

    // Metodo di Test: test che utilizza un valore parametrizzato
    @ParameterizedTest
    @Order(6)
    @MethodSource("provideTestCases")
    void testVerificaStringhe(String fruit) {
        System.out.println("Eseguito test: testVerificaStringhe, Ordine: 6");
        Assertions.assertTrue(fruit.length() > 0);  // Il test passa se la lunghezza della stringa è maggiore di 0
    }

    // Testa il metodo substringsBetween ispirato dalla libreria Apache Commons Lang
    @Test
    @Order(7)
    void testSottostringheTra() {
        System.out.println("Eseguito test: testSottostringheTra, Ordine: 7");
        String str = "axcaycaxc";
        String open = "a";
        String close = "c";

        String[] result = substringsBetween(str, open, close);

        Assertions.assertArrayEquals(new String[]{"x", "y", "x"}, result, "Le sottostringhe non corrispondono");
    }

    // Metodo da testare: restituire tutte le sottostringhe tra i tag "open" e "close"
    public static String[] substringsBetween(final String str, final String open, final String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        List<String> substrings = new ArrayList<>();
        int start = 0;
        while ((start = str.indexOf(open, start)) != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end == -1) break;
            substrings.add(str.substring(start + open.length(), end));
            start = end + close.length();
        }
        return substrings.toArray(new String[0]);
    }

    // Passaggio 1: Comprendere i requisiti
    @Test
    @Order(8)
    void testStringaNull() {
        System.out.println("Eseguito test: testStringaNull, Ordine: 8");
        Assertions.assertNull(substringsBetween(null, "a", "c"), "La stringa nulla dovrebbe restituire null");
    }

    @Test
    @Order(9)
    void testStringaVuota() {
        System.out.println("Eseguito test: testStringaVuota, Ordine: 9");
        Assertions.assertArrayEquals(new String[0], substringsBetween("", "a", "c"), "Una stringa vuota dovrebbe restituire un array vuoto");
    }

    @Test
    @Order(10)
    void testTagSingoloCarattere() {
        System.out.println("Eseguito test: testTagSingoloCarattere, Ordine: 10");
        Assertions.assertArrayEquals(new String[]{"x"}, substringsBetween("axc", "a", "c"), "Il risultato dovrebbe essere [x]");
    }

    @Test
    @Order(11)
    void testOccorrenzeMultiple() {
        System.out.println("Eseguito test: testOccorrenzeMultiple, Ordine: 11");
        Assertions.assertArrayEquals(new String[]{"x", "y", "x"}, substringsBetween("axcaycaxc", "a", "c"), "Le sottostringhe estratte sono errate");
    }

    @Test
    @Order(12)
    void testCasoLimiteNoMatch() {
        System.out.println("Eseguito test: testCasoLimiteNoMatch, Ordine: 12");
        Assertions.assertArrayEquals(new String[0], substringsBetween("abc", "d", "e"), "Non dovrebbero esserci sottostringhe");
    }

    @Test
    @Order(13)
    void testCasoLimiteTagVuoti() {
        System.out.println("Eseguito test: testCasoLimiteTagVuoti, Ordine: 13");
        Assertions.assertNull(substringsBetween("abc", "", "c"), "Il tag vuoto dovrebbe restituire null");
    }

    @Test
    @Order(14)
    void testTagVuoti() {
        System.out.println("Eseguito test: testTagVuoti, Ordine: 14");
        Assertions.assertNull(substringsBetween("abc", null, null), "Entrambi i tag nulli dovrebbero restituire null");
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @Order(15)
    void testCasiParametrizzati(String str, String open, String close, String[] expected) {
        System.out.println("Eseguito test: testCasiParametrizzati, Ordine: 15");
        Assertions.assertArrayEquals(expected, substringsBetween(str, open, close));
    }

    @Test
    @Order(16)
    void testCasoAutomatizzato() {
        System.out.println("Eseguito test: testCasoAutomatizzato, Ordine: 16");
        Assertions.assertArrayEquals(new String[]{"x"}, substringsBetween("axc", "a", "c"), "Il risultato dovrebbe essere [x]");
    }

    // Metodo che fornisce i dati per il test parametrizzato
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("axcaycaxc", "a", "c", new String[]{"x", "y", "x"}),
                Arguments.of("abcde", "b", "e", new String[]{"c", "d"})
        );
    }

    // Inizio del secondo PDF (Specification-based testing)
    @Test
    @Order(17)
    void testEsempioSpecifiche() {
        System.out.println("Eseguito test: testEsempioSpecifiche, Ordine: 17");
        String input = "axcaycaxc";
        String openTag = "a";
        String closeTag = "c";
        String[] expected = {"x", "y", "x"};

        String[] result = substringsBetween(input, openTag, closeTag);

        Assertions.assertArrayEquals(expected, result, "Le sottostringhe non sono corrette");
    }
}
