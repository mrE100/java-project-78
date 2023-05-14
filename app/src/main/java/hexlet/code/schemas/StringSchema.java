package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        super.required = true;
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

    @Override
    protected boolean isEmptyValue(Object data) {
        return data == null || (data instanceof String && ((String) data).isEmpty());
    }
}
