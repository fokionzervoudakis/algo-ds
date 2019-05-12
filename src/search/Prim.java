package search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Prim {
    /**
     Uses Prim's algorithm to find the minimum spanning tree of an undirected
     acyclic graph {@code G} from a source vertex {@code start}.
     <ul>
     <li>time_worst=O(V log V + E log V) with min heap implementation
     <li>time_worst=O(V^2) with array implementation
     </ul>

     @param G a graph
     @param start a source vertex in {@code G}
     */
    void minSpanTree(List<Vertex> G, Vertex start) {
        Queue<Vertex> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        // O(V log V)
        Q.addAll(G);

        start.d = 0;

        Set<Vertex> S = new HashSet<>();

        while (!Q.isEmpty()) {
            Vertex u = Q.remove();
            S.add(u);
            for (Vertex v : u.adj()) {
                if (!S.contains(v)) {
                    int d = u.weight(v);
                    if (v.d > d) {
                        v.d = d;
                        v.p = u;
                        // Update the heap: O(E log V)
                        Q.add(Q.remove());
                    }
                }
            }
        }
    }
}
