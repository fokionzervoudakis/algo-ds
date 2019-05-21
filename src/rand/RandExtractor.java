package rand;

import annotation.PseudoRandom;

import java.util.HashMap;
import java.util.Random;

class RandExtractor {
    @FunctionalInterface
    interface Coin {
        int tossBiased();
    }

    /**
     Implements the Von Neumann randomness extractor for producing a uniform
     distribution from nonuniform input.
     <p>For example, when tossing a coin the probability of deriving heads/tails
     is {@code P(H)=p} and {@code P(T)=1-p=q} respectively.
     <p>If a biased coin with {@code p=0.6} is tossed twice and cases {@code HH}
     and {@code TT} are discarded, then {@code HT} and {@code TH} will occur with
     equal probabilities (assumed independence of successive tosses):
     <ul>
     <li>{@code P(HH)=P(H)xP(H)=0.36}
     <li>{@code P(TT)=P(T)xP(T)=0.16}
     <li>{@code P(HT)=P(H)xP(T)=(1-P(HH)+P(TT))/2=0.24}
     <li>{@code P(TH)=P(T)xP(H)=(1-P(HH)+P(TT))/2=0.24}
     </ul>
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(1/pq)
     <li>space_worst=O(1)
     </ul>

     @param C a biased coin
     @return a uniformly distributed pseudo random number
     */
    @PseudoRandom
    static int tossUnbiased(Coin C) {
        while (true) {
            int m = C.tossBiased(), n = C.tossBiased();
            if (m != n) {
                return m;
            }
        }
    }

    private static int rand(Random R, int min, int max) {
        return R.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        var max = 10000;

        var R = new Random();

        Coin C = () -> rand(R, 0, 100) < 80 ? 0 : 1;

        var M1 = new HashMap<Integer, Double>();
        var M2 = new HashMap<Integer, Double>();

        for (var i = 0; i < max; i++) {
            int m = C.tossBiased(), n = tossUnbiased(C);
            M1.put(m, M1.containsKey(m) ? M1.get(m) + 1 : 1);
            M2.put(n, M2.containsKey(n) ? M2.get(n) + 1 : 1);
        }

        for (var E : M1.entrySet()) {
            M1.put(E.getKey(), E.getValue() / max);
        }

        for (var E : M2.entrySet()) {
            M2.put(E.getKey(), E.getValue() / max);
        }

        System.out.println(M1);
        System.out.println(M2);
    }
}
