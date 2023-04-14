package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {

    public Validator Validator() {
        return this;
    }

    public StringSchema string() {
        return new StringSchema();
    }
}
