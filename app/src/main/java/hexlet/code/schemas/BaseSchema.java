package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean required = false;
    private final Map<String, Predicate<Object>> checks = new HashMap<>();

    public final boolean isValid(Object data) {
        if (!required && isEmptyValue(data)) {
            return true;
        }
        return checks.values().stream().allMatch(ckeck -> ckeck.test(data));
    }

    protected abstract boolean isEmptyValue(Object data);

    protected BaseSchema() {
    }

    protected final void addChecks(String name, Predicate check) {
        checks.put(name, check);
    }
}
