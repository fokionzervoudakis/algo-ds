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

     @param str a string
     @param p a regex pattern
     @return true if {@code str} matches {@code p}, else false
     */
    boolean match(String str, String p) {
        if (p.isEmpty()) {
            return str.isEmpty();
        }
        char c = p.charAt(0);
        boolean b = !str.isEmpty() && (c == '.' || c == str.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return match(str, p.substring(2)) || (b && match(str.substring(1), p));
        } else {
            return b && match(str.substring(1), p.substring(1));
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

         @param str a string
         @param p a regex pattern
         @return true if {@code str} matches {@code p}, else false
         */
        boolean match(String str, String p) {
            if (M.containsKey(str)) {
                return M.get(str);
            } else {
                boolean match;
                if (p.isEmpty()) {
                    match = str.isEmpty();
                } else {
                    char c = p.charAt(0);
                    boolean b = !str.isEmpty() && (c == '.' || c == str.charAt(0));
                    if (p.length() >= 2 && p.charAt(1) == '*') {
                        match = match(str, p.substring(2)) || (b && match(str.substring(1), p));
                    } else {
                        match = b && match(str.substring(1), p.substring(1));
                    }
                }
                M.put(str, match);
                return match;
            }
        }
    }
}
