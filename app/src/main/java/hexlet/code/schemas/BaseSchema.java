package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean required = false;
    private final Map<String, Predicate<Object>> checks;

    public final boolean isValid(Object data) {
        return checks.values().stream().allMatch(ckeck -> ckeck.test(data));
    }

    protected BaseSchema() {
        this.checks = new HashMap<>();
    }

    protected final void addChecks(String name, Predicate check) {
        checks.put(name, check);
    }
}
