package hexlet.code.schemas;

public class BaseSchema {
    private boolean required = false;

    public boolean isValid(Object data) {
        if (!required) {
            return true;
        } return false;
    }

    public void required() {
        this.required = true;
    }
}
