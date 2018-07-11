package tw.core.model;

public class Record {
    private int[] value;

    public Record() {
        this.value = new int[]{0, 0};

    }

    public String getValue() {
        return String.format("%1$sA%2$sB", value[0], value[1]);
    }

    public void increaseCurrentNum() {
        this.value[0]++;
    }

    public void increaseIncludeOnlyNum() {
        this.value[1]++;
    }
}
