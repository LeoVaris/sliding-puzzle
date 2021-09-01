package solver;

public class IntegerList {
    int[] values;
    int currentIndex;

    /**
     * @param n The maximum size of the list
     */
    public IntegerList(int n) {
        this.values = new int[n];
        this.currentIndex = 0;
    }

    /**
     * @param value The value to add to the end of the list
     */
    public void add(int value) {
        this.values[this.currentIndex++] = value;
    }

    /**
     * @param index The index to get the value from.
     * @return Returns the value at the given index.
     */
    public int get(int index) {
        return this.values[index];
    }

    /**
     * @return Returns the current size of the list.
     */
    public int size() {
        return this.currentIndex;
    }
}
