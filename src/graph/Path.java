package graph;

class Path {
    static String print(Vertex src, Vertex dest) {
        if (dest.equals(src)) {
            return dest + "";
        } else if (dest.p == null) {
            return null;
        } else {
            return print(src, dest.p) + " -> " + dest;
        }
    }
}
