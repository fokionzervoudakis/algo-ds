package interview;

import java.util.HashMap;
import java.util.Map;

class DpRegex {
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
         @return true if {@code str} matches {@code p}, else false
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
