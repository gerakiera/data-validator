package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> mapOfPredicates = new HashMap<>();
    public boolean isValid(T t) {
        if (mapOfPredicates.isEmpty()) {
            return true;
        }
        for (var predicate : mapOfPredicates.values()) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
