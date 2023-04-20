package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int size;
    private boolean isSize = false;
    private boolean isSchemas = false;
    private Map<String, BaseSchema> schemas;

    public MapSchema MapSchema() {
        return this;
    }
    public void sizeof(int size) {
        this.size = size;
        isSize = true;
    }

    public boolean isValid(Object data) {
        if (super.isValid(data)) {
            if (data instanceof Map<?,?>) {
                if (isSchemas) {
                    for (Object key : schemas.keySet()) {
                         if (!schemas.get(key).isValid(((Map<?, ?>) data).get(key))) {
                             return false;
                         }
                    }
                }
                if (isSize) {
                    return (((Map<?, ?>) data).size() == size) ? true : false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        isSchemas = true;
        this.schemas = schemas;
    }
}
