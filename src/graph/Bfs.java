package graph;

import java.util.ArrayList;
import java.util.List;

class Bfs {
    /**
     * Uses breadth-first search to compute shortest path distances from a given
     * source vertex {@code s} to every vertex reachable from {@code s} in an
     * unweighted (directed/undirected) graph {@code G=(V,E)}.
     * <p>
     * Note: BFS is not an effective method for topological sort because
     * vertices in a shortest path need not be topologically ordered.
     * <ul>
     * <li>time_worst=O(V+E)
     * <li>space_worst=O(V)
     * </ul>
     *
     * @param G a graph
     * @param start the source vertex in {@code G}
     */
    void bfs(Graph G, Vertex start) {
        List<Vertex> Q = new ArrayList<>();
        Q.add(start);
        start.visited = true;
        while (!Q.isEmpty()) {
            Vertex u = Q.remove(0);
            for (Vertex v : G.outEdges(u)) {
                if (!v.visited) {
                    v.d = u.d + 1;
                    v.p = u;
                    v.visited = true;
                    Q.add(v);
                }
            }
        }
    }
}
