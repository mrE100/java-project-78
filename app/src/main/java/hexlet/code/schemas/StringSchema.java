package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public StringSchema required() {
        addChecks("required", value -> value instanceof String && !((String) value).isEmpty());
        return this;
    }

    public StringSchema contains(String data) {
        addChecks("contains", value -> ((String) value).contains(data));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addChecks("minLength", value -> ((String) value).length() >= minLength);
        return this;
    }
}
