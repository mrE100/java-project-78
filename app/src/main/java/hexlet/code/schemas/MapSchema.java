package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        addChecks("required", value -> value instanceof Map<?,?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        addChecks("sizeof", value -> ((Map) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addChecks("shape", value -> checkShape((Map) value, schemas));
        return this;
    }

    private boolean checkShape(Map<String, Object> value, Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> schema : schemas.entrySet()) {
            String name = schema.getKey();
            BaseSchema tempSchema = schema.getValue();
            Object tempValue = value.get(name);
            if (!tempSchema.isValid(tempValue)) {
                return false;
            }
        }
        return true;
    }


}
