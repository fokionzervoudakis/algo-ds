package graph;

class Vertex {
    private int key;

    private Vertex parent;

    Vertex() {
    }

    Vertex(int key) {
        this.key = key;
    }

    int getKey() {
        return key;
    }

    Vertex getParent() {
        return parent;
    }

    void setParent(Vertex v) {
        this.parent = v;
    }

    @Override
    public String toString() {
        return key + "";
    }
}
