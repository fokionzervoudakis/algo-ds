package search;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Dijkstra {
    /**
     Uses Dijkstra's algorithm to generate the shortest paths from a source
     vertex {@code start} to each vertex in a directed graph with non-negative
     edge weights.
     <ul>
     <li>time_worst=O(V log V + E log V) with min heap implementation
     <li>time_worst=O(V^2) with array implementation
     </ul>

     @param G a graph
     @param start a source vertex in {@code G}
     */
    void shortestPaths(List<Vertex> G, Vertex start) {
        Queue<Vertex> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        // O(V log V)
        Q.addAll(G);

        start.d = 0;

        while (!Q.isEmpty()) {
            Vertex u = Q.remove();
            for (Vertex v : u.adj()) {
                int d = u.d + u.weight(v);
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
