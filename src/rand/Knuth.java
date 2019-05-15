package rand;

import annotation.InPlace;
import annotation.PseudoRandom;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 {@link search.QuickSelect}
 {@link sort.QuickSort}
 */
public class Knuth {
    /**
     Uses the Fisher-Yates (in-place) shuffle to generate a pseudo-random
     permutation of {@code A}. The number of possible permutations is the
     factorial of the length of {@code A}.
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A the input array
     */
    @InPlace
    @PseudoRandom
    public static void shuffle(int[] A) {
        Random R = new Random();
        for (int i = 0; i < A.length - 1; i++) {
            swap(A, i, rand(R, i, A.length - 1));
        }
    }

    private static void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }

    private static int rand(Random R, int min, int max) {
        return R.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        var A = IntStream.range(0, 10).toArray();
        for (var i = 0; i < 10; i++) {
            var B = A.clone();
            Knuth.shuffle(B);
            System.out.println(Arrays.toString(B));
        }
    }
}
