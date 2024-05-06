package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> required = value -> (value != null && !value.isEmpty());
        listOfPredicates.add(required);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<String> minLen = str -> str.length() >= length;
        listOfPredicates.add(minLen);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> containsPredicate = (str -> str.contains(substring));
        listOfPredicates.add(containsPredicate);
        return this;
    }
}
