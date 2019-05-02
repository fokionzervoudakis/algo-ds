package graph;

import java.util.ArrayList;
import java.util.List;

class Coloring {
    class Bfs {
        boolean isBipartite(Graph<Vertex> G, Vertex start) {
            List<Vertex> Q = new ArrayList<>();
            Q.add(start);
            start.visited = true;
            start.c = Color.WH;
            while (!Q.isEmpty()) {
                Vertex u = Q.remove(0);
                for (Vertex v : G.outEdges(u)) {
                    if (v.visited || v.c == u.c) {
                        return false;
                    } else {
                        v.d = u.d + 1;
                        v.p = u;
                        v.c = complement(u.c);
                        v.visited = true;
                        Q.add(v);
                    }
                }
            }
            return true;
        }
    }

    private Color complement(Color c) {
        return (c == Color.WH) ? Color.BK : Color.WH;
    }

    enum Color {
        BK, WH
    }

    static class Vertex extends graph.Vertex {
        Color c;

        Vertex(int key) {
            super(key);
        }

        @Override
        public String toString() {
            return super.toString() + ":" + c;
        }
    }
}
