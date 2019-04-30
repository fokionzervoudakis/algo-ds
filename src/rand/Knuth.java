package rand;

import annotation.InPlace;
import annotation.PseudoRandom;

import java.util.Arrays;
import java.util.Random;

class Knuth {
    Random R = new Random();

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
    void shuffle(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            swap(A, i, rand(i, A.length - 1));
        }
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }

    private int rand(int min, int max) {
        return R.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Knuth K = new Knuth();
        for (int i = 0; i < 10; i++) {
            int[] B = A.clone();
            K.shuffle(B);
            System.out.println(Arrays.toString(B));
        }
    }
}
