package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int size;
    private boolean isSize = false;

    public MapSchema MapSchema() {
        return this;
    }
    public void sizeof(int size) {
        this.size = size;
        isSize = true;
    }

    public boolean isValid(Object data) {
        if (!super.isValid(data)) {
            if (data instanceof Map<?,?>) {
                if (isSize) {
                    return (((Map<?, ?>) data).size() == size) ? true : false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
}
