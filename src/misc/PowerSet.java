package misc;

import java.util.ArrayList;
import java.util.List;

class PowerSet<T> {
    List<List<T>> L = new ArrayList<>();

    /**
     Generates the power set of {@code A}.
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param A the target array
     @return the power set of {@code A}
     */
    List<List<T>> generate(T[] A) {
        helper(A, A.length);
        return L;
    }

    private void helper(T[] A, int n) {
        if (n == 0) {
            // Add the empty set.
            L.add(new ArrayList<>());
        } else {
            int m = n - 1;
            helper(A, m);
            // Copy the power set to avoid a concurrent modification exception.
            for (List<T> tmp : new ArrayList<>(L)) {
                // For every subset currently in the power set, create a new set
                // by appending the current item to a copy of that set.
                L.add(new ArrayList<>() {{
                    addAll(tmp);
                    add(A[m]);
                }});
            }
        }
    }
}
