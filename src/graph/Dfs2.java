package graph;

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
        u.color = Color.GRAY;
        for (Vertex v : G.outEdges(u)) {
            if (v.color == Color.GRAY) {
                throw new RuntimeException();
            } else if (v.color == Color.WHITE) {
                v.setParent(u);
                v.color = Color.GRAY;
                dfs(G, v);
            }
        }
        u.color = Color.BLACK;
    }

    static class Vertex extends graph.Vertex {
        Color color = Color.WHITE;

        Vertex(int key) {
            super(key);
        }
    }
}
