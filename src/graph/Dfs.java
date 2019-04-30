package graph;

import java.util.Stack;

class Dfs {
    class It {
        /**
         * Uses iterative depth-first search backed by a last-in-first-out data
         * structure to detect cycles, and topologically sort all vertices, in a
         * directed acyclic graph {@code G=(V,E)}.
         * <ul>
         * <li>time_worst=O(V+E)
         * <li>space_worst=O(V)
         * </ul>
         *
         * @param G a graph
         */
        void dfs(Graph G) {
            for (Vertex v : G) {
                if (!v.visited) {
                    dfsVisit(G, v);
                }
            }
        }

        // TODO cycle detection
        private void dfsVisit(Graph G, Vertex s) {
            Stack<Vertex> S = new Stack<>();
            S.push(s);
            while (!S.isEmpty()) {
                Vertex u = S.pop();
                u.visited = true;
                for (Vertex v : G.outEdges(u)) {
                    if (!v.visited) {
                        v.p = u;
                        S.push(v);
                    }
                }
            }
        }
    }

    class Rec {
        /**
         * Uses recursive depth-first search to detect cycles, and topologically
         * sort all vertices, in a directed acyclic graph {@code G=(V,E)}.
         * <ul>
         * <li>time_worst=O(V+E)
         * <li>space_worst=O(V)
         * </ul>
         *
         * @param G a graph
         */
        void dfs(Graph G) {
            for (Vertex v : G) {
                if (!v.visited) {
                    dfsVisit(G, v);
                }
            }
        }

        // TODO cycle detection
        private void dfsVisit(Graph G, Vertex u) {
            u.visited = true;
            for (Vertex v : G.outEdges(u)) {
                if (!v.visited) {
                    v.p = u;
                    dfsVisit(G, v);
                }
            }
        }
    }
}
