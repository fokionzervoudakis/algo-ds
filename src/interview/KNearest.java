package interview;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class KNearest {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(n log k)
     <li>space_worst=O(k)
     </ul>

     @param L a list of points
     @param P an origin point
     @param k the number of closest points to {@code u} in terms of Euclidean
     distance
     @return the {@code k} closest points to {@code u}
     */
    Queue<Node> getNearest(List<Point> L, Point P, int k) {
        assert k > 0;
        Queue<Node> Q = new PriorityQueue<>((o1, o2) -> Double.compare(o2.d, o1.d));
        for (Point P2 : L) {
            double d = dist(P, P2);
            if (Q.size() == k) {
                Node N = Q.peek();
                if (N.d > d) {
                    Q.remove(N);
                    Q.add(new Node(P2, d));
                }
            } else {
                Q.add(new Node(P2, d));
            }
        }
        return Q;
    }

    /**
     @param P1 a point in Euclidean space
     @param P2 another point in Euclidean space
     @return the Euclidean distance between {@code P1} and {@code P2}
     */
    private double dist(Point P1, Point P2) {
        return Math.sqrt(Math.pow(P1.x - P2.x, 2) + Math.pow(P1.y - P2.y, 2));
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }

    static class Node {
        Point p;
        double d;

        Node(Point p, double d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public String toString() {
            return p.toString();
        }
    }
}
