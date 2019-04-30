package misc;

class Fib {
    /**
     Uses iteration to calculate the {@code n}th Fibonacci number.
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param n a number
     @return the {@code n}th Fibonacci number
     */
    int it(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    /**
     Uses recursion to calculate the {@code n}th Fibonacci number.
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param n a number
     @return the {@code n}th Fibonacci number
     */
    int rec(int n) {
        return (n < 2) ? n : (rec(n - 1) + rec(n - 2));
    }
}
