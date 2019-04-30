package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 Asymptotic analysis:
 <ul>
 <li>addEdge=O(1)
 <li>removeEdge=O(E)
 <li>hasEdge=O(E)
 <li>inEdges=O(V+E)
 <li>outEdges=O(1)
 <li>space=O(V+E)
 </ul>
 */
class ObjGraph implements Graph {
    private int n;
    private Vertex[] A;

    ObjGraph(int n) {
        this.n = n;
        this.A = new Vertex[n];
    }

    @Override
    public void addVertex(Vertex u) {
        if (A[u.key] == null) {
            A[u.key] = u;
        }
    }

    @Override
    public void addEdge(Vertex u, Vertex v) {
        addVertex(u);
        addVertex(v);
        ((ObjVertex) A[u.key]).add(v);
    }

    @Override
    public void removeEdge(Vertex u, Vertex v) {
        ((ObjVertex) A[u.key]).remove(v);
    }

    @Override
    public boolean hasEdge(Vertex u, Vertex v) {
        return ((ObjVertex) A[u.key]).hasEdge(v);
    }

    @Override
    public List<Vertex> inEdges(Vertex u) {
        var L = new ArrayList<Vertex>();
        for (int i = 0; i < n; i++) {
            var v = A[i];
            if (v != null && ((ObjVertex) v).hasEdge(u)) {
                L.add(v);
            }
        }
        return L;
    }

    @Override
    public List<Vertex> outEdges(Vertex u) {
        return ((ObjVertex) A[u.key]).outEdges();
    }

    @Override
    public Iterator<Vertex> iterator() {
        return Arrays.stream(A).iterator();
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }

    static class ObjVertex extends Vertex {
        List<Vertex> L = new ArrayList<>();

        ObjVertex(int key) {
            super(key);
        }

        void add(Vertex v) {
            L.add(v);
        }

        void remove(Vertex v) {
            L.remove(v);
        }

        boolean hasEdge(Vertex v) {
            return L.contains(v);
        }

        List<Vertex> outEdges() {
            return L;
        }

        @Override
        public String toString() {
            return super.toString() + "=" + toS(L);
        }

        String toS(List<Vertex> L) {
            return L.stream().map(v -> v.key + "").collect(Collectors.joining(", ", "[", "]"));
        }
    }
}
