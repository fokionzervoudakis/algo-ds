package misc;

class BoyerM {
    /**
     Uses the Boyer-Moore majority vote algorithm to find the majority element
     (i.e. the element that appears more than {@code n/2} times) in an array of
     {@code n} integers.
     <p>The algorithm will report one of the elements even if the array contains
     no majority element. A second pass must be used to determine whether the
     element returned is the majority element.
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A an array of integers
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
