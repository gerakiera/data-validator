package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {
    /*@Override
    public NumberSchema required() {
        super.required();
        return this;
    }*/
    public NumberSchema required() {
        Predicate<Integer> required = Objects::nonNull;
        listOfPredicates.add(required);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Integer> pos = num -> num != null && num > 0;
        listOfPredicates.add(pos);
        return this;
    }
    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = num -> num != null && num >= min && num <= max;
        listOfPredicates.add(range);
        return this;
    }
}
