package graph;

class Vertex {
    int d = 0;
    boolean visited = false;

    Vertex p;

    int key;

    Vertex(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key + "";
    }
}
