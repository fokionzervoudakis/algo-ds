package rand;

import annotation.PseudoRandom;

import java.util.Random;
import java.util.stream.IntStream;

class AlgorithmR {
    Random R = new Random();

    /**
     Uses Algorithm R to uniformly select a random element from {@code A}.
     <p>
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A an integer array
     @return a random element selected uniformly from {@code A}
     */
    @PseudoRandom
    int pick(int[] A) {
        int i = 0, out = i;
        for (int n : A) {
            if (i == 0 || rand(1, i + 1) == 1) {
                out = n;
            }
            i++;
        }
        return out;
    }

    private int rand(int min, int max) {
        return R.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        var algorithmA = new AlgorithmR();
        var A = IntStream.range(0, 100).toArray();
        for (int i = 0; i < 10; i++) {
            System.out.println(algorithmA.pick(A));
        }
    }
}
