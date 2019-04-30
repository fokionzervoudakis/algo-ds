package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.SOURCE)
public @interface Pattern {
    Type[] value();

    enum Type {
        BRUTE_FORCE, COUNTING, DIVIDE_AND_CONQUER, GREEDY, HASH_TABLE
    }
}
