package org.example;

public final class NumberUtils {

    private NumberUtils() {
        // utility class: costruttore privato
    }

    /**
     * Classifica un intero come ZERO, PARI o DISPARI.
     *
     * @param n intero in ingresso
     * @return "ZERO" se n == 0, "PARI" se n è pari (e ≠ 0), altrimenti "DISPARI"
     */
    public static String classifyNumber(int n) {
        if (n == 0) return "ZERO";
        return (n % 2 == 0) ? "PARI" : "DISPARI";
    }

    /**
     * Restituisce true se n è un multiplo di k.
     * @param n intero
     * @param k divisore (non zero)
     * @return true se n % k == 0
     * @throws IllegalArgumentException se k == 0
     */
    public static boolean isMultipleOf(int n, int k) {
        if (k == 0) {
            throw new IllegalArgumentException("k must be non-zero");
        }
        return n % k == 0;
    }

}