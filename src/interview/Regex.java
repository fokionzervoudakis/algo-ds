package interview;

class Regex {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param s a string
     @param p a regex pattern
     @return true if {@code s} matches {@code p}, else false
     */
    boolean match(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        char c = p.charAt(0);
        boolean b = !s.isEmpty() && (c == '.' || c == s.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return match(s, p.substring(2)) || (b && match(s.substring(1), p));
        } else {
            return b && match(s.substring(1), p.substring(1));
        }
    }
}
