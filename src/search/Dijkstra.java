package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Dijkstra {
    /**
     Uses Dijkstra's algorithm to generate the shortest paths from a source
     vertex {@code s} to each vertex in a directed graph with non-negative edge
     weights.
     <ul>
     <li>time_worst=O(V log V + E log V) with min heap implementation
     <li>time_worst=O(V^2) with array implementation
     </ul>

     @param G a graph
     @param start a source vertex in {@code G}
     @return a list of vertices with enumerated shortest paths to {@code s}
     */
    List<Vertex> shortestPaths(List<Vertex> G, Vertex start) {
        Queue<Vertex> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        Q.addAll(G);

        Set<Vertex> S = new LinkedHashSet<>();

        start.d = 0;

        while (!Q.isEmpty()) {
            // O(V log V)
            Vertex u = Q.remove();
            S.add(u);
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

        return new ArrayList<>(S);
    }

    //<editor-fold desc="graph">
    static class Vertex {
        int d = Integer.MAX_VALUE;

        Vertex p;

        List<Edge> edges = new ArrayList<>();

        List<Vertex> adj() {
            return edges.stream().map(e -> e.target).collect(Collectors.toList());
        }

        int weight(Vertex v) {
            for (var e : edges) {
                if (e.target.equals(v)) {
                    return e.weight;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "(" + d + ": " + p + ")";
        }
    }

    static class Edge {
        Vertex target;
        int weight;

        Edge(Vertex target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    //</editor-fold
}
