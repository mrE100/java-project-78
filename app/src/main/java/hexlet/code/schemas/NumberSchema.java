package hexlet.code.schemas;

public class NumberSchema extends BaseSchema{
    private int start;
    private int finish;
    private boolean isRange = false;
    private boolean isPositive = false;

    public NumberSchema NumberSchema() {
        return this;
    }


    @Override
    public boolean isValid(Object data) {
        if (super.isValid(data)) {
            if (data instanceof Integer) {
                int currentData = (Integer) data;
                if (isRange) {
                    return (currentData >= start && currentData <= finish) ? true : false;
                }
                if (isPositive) {
                    return (currentData > 0) ? true : false;
                }
                return true;
            }
            if (!super.isRequired()) {
                return true;
            }
            return false;
        }

        return false;
    }

    public void range (int start, int finish) {
        this.start = start;
        this.finish = finish;
        this.isRange = true;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }
}
