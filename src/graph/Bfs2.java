package graph;

import java.util.ArrayList;
import java.util.List;

import static graph.Color.BLACK;
import static graph.Color.WHITE;

class Bfs2 {
    boolean isBipartite(Graph<Vertex> G, Vertex start) {
        List<Vertex> Q = new ArrayList<>();
        Q.add(start);
        start.visited = true;
        start.color = WHITE;
        while (!Q.isEmpty()) {
            Vertex u = Q.remove(0);
            for (Vertex v : G.outEdges(u)) {
                if (v.visited || v.color == u.color) {
                    return false;
                } else {
                    v.setParent(u);
                    v.d = u.d + 1;
                    v.visited = true;
                    v.color = u.complement();
                    Q.add(v);
                }
            }
        }
        return true;
    }

    static class Vertex extends graph.Vertex {
        int d = 0;
        boolean visited = false;

        Color color;

        Vertex(int key) {
            super(key);
        }

        Color complement() {
            return (color == WHITE) ? BLACK : WHITE;
        }

        @Override
        public String toString() {
            return super.toString() + ":" + color + ":" + d;
        }
    }
}
