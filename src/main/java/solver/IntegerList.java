package solver;

public class IntegerList {
    int[] values;
    int currentIndex;

    public IntegerList(int n) {
        this.values = new int[n];
        this.currentIndex = 0;
    }

    public void add(int value) {
        this.values[this.currentIndex++] = value;
    }

    public int get(int index) {
        return this.values[index];
    }

    public int size() {
        return this.currentIndex;
    }
}
