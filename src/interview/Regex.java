package interview;

import java.util.HashMap;
import java.util.Map;

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

        // The first character will not be a wildcard.
        boolean b = !s.isEmpty() && (c == '.' || c == s.charAt(0));

        // If the second character is a wildcard...
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // then the regex consumes either zero characters or one character,
            return match(s, p.substring(2)) || (b && match(s.substring(1), p));
        } else {
            // else the regex consumes one character.
            return b && match(s.substring(1), p.substring(1));
        }
    }

    class Mem {
        Map<String, Boolean> M = new HashMap<>();

        /**
         Asymptotic analysis:
         <ul>
         <li>time_worst=O(n)
         <li>space_worst=O(n)
         </ul>

         @param s a string
         @param p a regex pattern
         @return true if {@code s} matches {@code p}, else false
         */
        boolean match(String s, String p) {
            if (M.containsKey(s)) {
                return M.get(s);
            } else {
                boolean match;

                if (p.isEmpty()) {
                    match = s.isEmpty();
                } else {
                    char c = p.charAt(0);

                    boolean b = !s.isEmpty() && (c == '.' || c == s.charAt(0));

                    if (p.length() >= 2 && p.charAt(1) == '*') {
                        match = match(s, p.substring(2)) || (b && match(s.substring(1), p));
                    } else {
                        match = b && match(s.substring(1), p.substring(1));
                    }
                }

                M.put(s, match);
                return match;
            }
        }
    }
}
