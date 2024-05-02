package hexlet.code;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        /*Predicate<Integer> req = num -> num != null;
        listOfPredicates.add(req);*/
        super.required();
        return this;
    }
    public NumberSchema positive() {
        Predicate<Integer> pos = num -> num >= 0;
        listOfPredicates.add(pos);
        return this;
    }
    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = num -> num > min && num < max;
        listOfPredicates.add(range);
        return this;
    }
}
