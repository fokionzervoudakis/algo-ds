package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 The adjacency matrix representation is preferred for dense graphs or fast
 lookups. It is also used because matrix algebra can efficiently compute
 properties of the underlying graph.
 <p>
 Asymptotic analysis:
 <ul>
 <li>addEdge=O(1)
 <li>removeEdge=O(1)
 <li>hasEdge=O(1)
 <li>inEdges=O(n)
 <li>outEdges=O(n)
 <li>space=O(n^2)
 </ul>
 */
class AdjMatrix<T extends Vertex> implements Graph<T> {
    private int n;
    private T[][] M;

    AdjMatrix(int n) {
        this.n = n;
        this.M = (T[][]) new Vertex[n][n];
    }

    @Override
    public void addVertex(T u) {
        M[u.key][u.key] = u;
    }

    @Override
    public void addEdge(T u, T v) {
        addVertex(u);
        addVertex(v);
        M[u.key][v.key] = v;
    }

    @Override
    public void removeEdge(T u, T v) {
        M[u.key][v.key] = null;
    }

    @Override
    public boolean hasEdge(T u, T v) {
        return M[u.key][v.key] != null;
    }

    @Override
    public List<T> inEdges(T u) {
        var L = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            if (i != u.key) {
                var v = M[i][u.key];
                if (v != null) {
                    L.add(M[i][i]);
                }
            }
        }
        return L;
    }

    @Override
    public List<T> outEdges(T u) {
        var L = new ArrayList<T>();
        for (int j = 0; j < n; j++) {
            if (j != u.key) {
                var v = M[u.key][j];
                if (v != null) {
                    L.add(v);
                }
            }
        }
        return L;
    }

    @Override
    public Iterator<T> iterator() {
        var L = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            var v = M[i][i];
            if (v != null) {
                L.add(v);
            }
        }
        return L.iterator();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Arrays.toString(M[i]));
            if (i < n - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
