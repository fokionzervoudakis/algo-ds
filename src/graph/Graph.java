package graph;

import java.util.List;

public interface Graph extends Iterable<Vertex> {
    void addVertex(Vertex u);

    void addEdge(Vertex u, Vertex v);

    void removeEdge(Vertex u, Vertex v);

    boolean hasEdge(Vertex u, Vertex v);

    List<Vertex> inEdges(Vertex u);

    List<Vertex> outEdges(Vertex u);
}
