package graph;

import java.util.List;

public interface Graph<T extends Vertex> extends Iterable<T> {
    void addVertex(T u);

    void addEdge(T u, T v);

    void removeEdge(T u, T v);

    boolean hasEdge(T u, T v);

    List<T> inEdges(T u);

    List<T> outEdges(T u);
}
