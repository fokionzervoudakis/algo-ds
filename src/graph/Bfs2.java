package graph;

import java.util.Deque;
import java.util.LinkedList;

class Bfs2 {
    boolean isBipartite(Graph<Vertex> G, Vertex start) {
        Deque<Vertex> D = new LinkedList<>();
        D.add(start);
        start.visited = true;
        start.color = Color.WHITE;
        while (!D.isEmpty()) {
            Vertex u = D.removeFirst();
            for (Vertex v : G.outEdges(u)) {
                if (v.visited || v.color == u.color) {
                    return false;
                } else {
                    v.setParent(u);
                    v.d = u.d + 1;
                    v.visited = true;
                    v.color = u.complement();
                    D.addLast(v);
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
            return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }

        @Override
        public String toString() {
            return super.toString() + ":" + color + ":" + d;
        }
    }
}
