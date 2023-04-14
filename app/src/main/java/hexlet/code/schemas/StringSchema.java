package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private String data;

    private int minLength;

    public StringSchema StringSchema() {
        return this;
    }

    public boolean isValid(Object someData) {
        if (!super.isValid(someData)) {
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
