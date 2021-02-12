package com.nu.kovalova.finalTask.arithmetic;

/**
 * The class {@code arithmetic} contains methods for performing calculating
 * sequence k = [1, N] ((-1)^(k + 1) / ((k + 1) * k)) for the natural argument N.
 *
 * @author Tetiana O. Kovalova
 * @since JDK 11
 */
public class Sequence {

    private Sequence() {
    }

    /**
     * Returns the sum of the sequence k = [1, N] ((-1)^(k + 1) / ((k + 1) * k))
     * throwing an IllegalArgumentException if argument is not natural number {@code int}.
     *
     * @param n natural number.
     * @return the sum of elements.
     * @throws IllegalStateException if the {@code argument} is not natural number (number should be integer, positive and greater than 0)
     */
    public static double calculate(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Argument must be natural (number should be integer, positive and greater than 0):");
        }
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            sum += Math.pow(-1, k + 1) / ((k + 1) * k);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sequence.calculate(10));
    }
}