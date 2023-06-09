package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        super.required = true;
        addChecks("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addChecks("positive", value -> (value instanceof Integer && (int) value > 0));
        return this;
    }

    public NumberSchema range(int start, int end) {
        addChecks("range", value -> ((int) value >= start && (int) value <= end));
        return this;
    }

    @Override
    protected boolean isEmptyValue(Object data) {
        return data == null;
    }
}
