package search;

import java.util.List;

class BellmanF {
    /**
     Uses the Bellman-Ford algorithm to generate the shortest paths from a source
     vertex {@code start} to each vertex in a directed graph that may contain
     negative edge weights.
     <ul>
     <li>time_best=O(E)
     <li>time_worst=O(VE)
     <li>time_worst=O(V)
     </ul>

     @param G a graph
     @param start a source vertex in {@code G}
     @return true if {@code G} contains negative edge weights, else false
     */
    // TODO test with cycles
    boolean shortestPaths(List<Vertex> G, Vertex start) {
        start.d = 0;
        for (int i = 0; i < G.size(); i++) {
            for (Vertex u : G) {
                for (Vertex v : u.adj()) {
                    int d = u.d + u.weight(v);
                    if (v.d > d) {
                        v.d = d;
                        v.p = u;
                    }
                }
            }
        }
        for (int i = 0; i < G.size(); i++) {
            for (Vertex u : G) {
                for (Vertex v : u.adj()) {
                    int d = u.d + u.weight(v);
                    if (v.d > d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
