package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GraphColor {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(V+E)
     <li>space_worst=O(V)
     </ul>

     @param A an array of graph vertices
     @param B an array of colors
     */
    void color(Vertex[] A, String[] B) {
        for (Vertex v1 : A) {
            if (v1.neighbors.contains(v1)) {
                throw new RuntimeException();
            }
            Set<String> S = new HashSet<>();
            for (Vertex v2 : v1.neighbors) {
                S.add(v2.color);
            }
            for (String s : B) {
                if (!S.contains(s)) {
                    v1.color = s;
                    break;
                }
            }
        }
    }

    static class Vertex {
        int key;

        String color;

        List<Vertex> neighbors = new ArrayList<>();

        Vertex(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + ":" + color + "=" + printNeighbors();
        }

        private String printNeighbors() {
            return neighbors.stream().map(n -> n.key + ":" + n.color).collect(Collectors.joining(", ", "[", "]"));
        }
    }
}
