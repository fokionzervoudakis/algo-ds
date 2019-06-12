package graph;

import static graph.Color.BLACK;
import static graph.Color.GRAY;
import static graph.Color.WHITE;

class Dfs2 {
    /**
     Uses recursive depth-first search to detect cycles in a directed acyclic
     graph {@code G=(V,E)}. In the absence of cycles, all vertices in {@code G}
     are sorted topologically.
     <ul>
     <li>time_worst=O(V+E)
     <li>space_worst=O(V)
     </ul>

     @param G a graph
     */
    void dfs(Graph<Vertex> G, Vertex u) {
        u.color = GRAY;
        for (Vertex v : G.outEdges(u)) {
            if (v.color == GRAY) {
                throw new RuntimeException();
            } else if (v.color == WHITE) {
                v.setParent(u);
                v.color = GRAY;
                dfs(G, v);
            }
        }
        u.color = BLACK;
    }

    static class Vertex extends graph.Vertex {
        Color color = WHITE;

        Vertex(int key) {
            super(key);
        }
    }
}
