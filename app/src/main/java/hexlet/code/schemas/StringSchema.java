package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private String data;

    private int minLength = 0;

    public StringSchema StringSchema() {
        return this;
    }

    @Override
    public boolean isValid(Object someData) {
        if (!super.isRequired()) {
            return true;
        }
        if (super.isValid(someData)) {
            if (someData instanceof String) {
                if (data != null) {
                    return (((String) someData).contains(data)) ? true : false;
                }
                if (((String) someData).length() > minLength) {
                    return true;
                } return false;
            }
            return false;
        }
        return false;
    }

    public void contains(String data) {
        this.data = data;
    }

    public void minLength(int minLength) {
        minLength = minLength;
    }
}
