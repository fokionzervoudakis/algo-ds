package graph;

class Path {
    static String print(Vertex src, Vertex dest) {
        if (dest.equals(src)) {
            return dest + "";
        } else if (dest.getParent() == null) {
            return null;
        } else {
            return print(src, dest.getParent()) + " -> " + dest;
        }
    }
}
