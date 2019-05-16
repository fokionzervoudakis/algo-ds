package rand;

import annotation.PseudoRandom;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

class AlgorithmR {
    /**
     Uses Algorithm R to uniformly select a random element from {@code A} (a.k.a
     reservoir sampling).
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A an integer array
     @return a random element selected uniformly from {@code A}
     */
    @PseudoRandom
    static int pick(int[] A) {
        Random R = new Random();
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || rand(R, 1, i + 1) == 1) {
                n = A[i];
            }
        }
        return n;
    }

    private static int rand(Random R, int min, int max) {
        return R.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        var max = 10000;
        var A = IntStream.range(0, 10).toArray();
        var M = new HashMap<Integer, Double>();
        for (var i = 0; i < max; i++) {
            var n = AlgorithmR.pick(A);
            M.put(n, M.containsKey(n) ? M.get(n) + 1 : 1);
        }
        for (var E : M.entrySet()) {
            M.put(E.getKey(), E.getValue() / max);
        }
        System.out.println(M);
    }
}
