package interview;

import java.util.ArrayList;
import java.util.List;

class Spiral {
    List<Integer> clockwise(int[][] M) {
        List<Integer> L = new ArrayList<>();

        if (M.length == 0) {
            return L;
        }

        int t = 0, b = M.length - 1, l = 0, r = M[0].length - 1;

        while (true) {
            for (int i = l; i <= r; i++) L.add(M[t][i]);
            if (++t > b) break;

            for (int i = t; i <= b; i++) L.add(M[i][r]);
            if (l > --r) break;

            for (int i = r; i >= l; i--) L.add(M[b][i]);
            if (t > --b) break;

            for (int i = b; i >= t; i--) L.add(M[i][l]);
            if (++l > r) break;
        }

        return L;
    }
}
