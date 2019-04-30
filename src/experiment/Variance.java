package experiment;

import java.util.ArrayList;
import java.util.List;

class Variance {
    public static void main(String[] args) {
        // Covariance in arrays:

        var A = new Integer[] { 1 };
        Object[] B = A;
        var n = B[0]; // The array is covariant so reading is safe...

        System.out.println(n); // 1

        try {
            B[0] = new Object(); // but writing causes a run-time error.
        } catch (ArrayStoreException ignored) {
        }

        // Covariance in generic collections:

        List<? extends Number> L1 = new ArrayList<>() {{
            add(1d); // double extends number
            add(2f); // float extends number
        }};

        // Because the list is upper-bounded reading numbers is safe...
        Number n1 = L1.get(0), n2 = L1.get(1);

        System.out.println(n1); // 1.0
        System.out.println(n2); // 2.0

        // but writing causes a compile-time error (because the element type accepted by the collection is unknown)...
        // L1.add(3);

        // except when writing null (because the null reference can be assigned or cast to any reference type).
        L1.add(null);

        // Contravariance in generic collections:

        List<? super Number> L2 = new ArrayList<>();

        // Because the list is lower-bounded writing numbers (and number subtypes) is safe...
        L2.add(3d); // double extends number
        L2.add(4f); // float extends number

        // but reading causes a compile-time error (because the element type returned by the collection is unknown)...
        // Double d = L2.get(0);

        // except when reading an instance of Object.
        Object o1 = L2.get(0), o2 = L2.get(1);

        System.out.println(o1); // 3.0
        System.out.println(o2); // 4.0
    }
}
