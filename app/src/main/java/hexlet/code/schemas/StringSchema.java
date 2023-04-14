package hexlet.code.schemas;

public class StringSchema {
    private String data;
    private boolean required = false;
    private int minLength;

    public StringSchema StringSchema() {
        return this;
    }

    public void required() {
        this.required = true;
    }

    public boolean isValid(Object someData) {
        if (required) {
            if (someData instanceof String) {
                if (data != null) {
                    return (((String) someData).contains(data)) ? true : false;
                } return true;
            }
            return false;
        }
        return true;
    }

    public void contains(String data) {
        this.data = data;
    }

    public void minLength(int minLength) {
        minLength = minLength;
    }
}
