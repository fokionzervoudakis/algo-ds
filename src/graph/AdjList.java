package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 The adjacency list representation is preferred for sparse graphs.
 <p>
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
class AdjList<T extends Vertex> implements Graph<T> {
    private Map<T, List<T>> M = new LinkedHashMap<>(); // Order for test determinism.

    @Override
    public void addVertex(T u) {
        if (!M.containsKey(u)) {
            M.put(u, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(T u, T v) {
        addVertex(u);
        addVertex(v);
        M.get(u).add(v);
    }


    @Override
    public void removeEdge(T u, T v) {
        var it = M.get(u).iterator();
        while (it.hasNext()) {
            if (it.next().equals(v)) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public boolean hasEdge(T u, T v) {
        return M.get(u).contains(v);
    }

    @Override
    public List<T> inEdges(T u) {
        var L = new ArrayList<T>();
        M.forEach((v, adj) -> {
            if (adj.contains(u)) {
                L.add(v);
            }
        });
        return L;
    }

    @Override
    public List<T> outEdges(T u) {
        return M.get(u);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayList<>(M.keySet()).iterator();
    }

    @Override
    public String toString() {
        return M.toString();
    }
}
