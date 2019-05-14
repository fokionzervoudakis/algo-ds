package misc;

class BoyerM {
    /**
     Uses the Boyer-Moore majority vote algorithm to find the majority element in
     an array of integers
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A an array of {@code n} integers containing a majority element that
     appears more than {@code n/2} times
     @return the majority element of {@code A}
     */
    Integer majorityVote(int[] A) {
        int i = 0;
        Integer m = null;
        for (int n : A) {
            if (i == 0) {
                m = n;
                i++;
            } else if (m == n) {
                i++;
            } else {
                i--;
            }
        }
        return m;
    }
}
