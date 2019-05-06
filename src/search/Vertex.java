package search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Vertex {
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
