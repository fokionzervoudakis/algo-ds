package graph;

import java.util.Deque;
import java.util.LinkedList;

class Bfs {
    /**
     Uses breadth-first search to compute shortest path distances from a given
     source vertex {@code start} to every vertex reachable from {@code start} in
     an unweighted (directed/undirected) graph {@code G=(V,E)}.
     <p>
     Note: BFS is not an effective method for topological sort because vertices
     in a shortest path need not be topologically ordered.
     <ul>
     <li>time_worst=O(V+E)
     <li>space_worst=O(V)
     </ul>

     @param G a graph
     @param start the source vertex in {@code G}
     */
    void bfs(Graph<Vertex> G, Vertex start) {
        Deque<Vertex> Q = new LinkedList<>();
        Q.add(start);
        start.visited = true;
        while (!Q.isEmpty()) {
            Vertex u = Q.removeFirst();
            for (Vertex v : G.outEdges(u)) {
                if (!v.visited) {
                    v.setParent(u);
                    v.d = u.d + 1;
                    v.visited = true;
                    Q.addLast(v);
                }
            }
        }
    }

    static class Vertex extends graph.Vertex {
        int d = 0;
        boolean visited = false;

        Vertex(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return super.toString() + ":" + d;
        }
    }
}
