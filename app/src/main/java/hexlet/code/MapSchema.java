package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<String,String>> {
    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
    public MapSchema sizeof(int size) {
        Predicate<Map<String,String>> mapSize = map -> map.size() >= size;
        listOfPredicates.add(mapSize);
        return this;
    }
}
