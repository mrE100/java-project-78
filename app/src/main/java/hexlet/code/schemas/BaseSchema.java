package hexlet.code.schemas;

public class BaseSchema {
    private boolean required = false;

    public boolean isValid(Object data) {
        return (required) ? ((data == null) ? false : true) : true;
    }

    public boolean isRequired() {
        return required;
    }

    public BaseSchema required() {
        this.required = true;
        return this;
    }
}
