package solver;

public class Solver {
    int[][] grid;

    public Solver(int[][] grid) {
        this.grid = grid;
    }

    public boolean isSolvable() {
        int n = this.grid.length;

        int inversions = 0;

        // This could be calculated in O(n log n), but O(n^2) is good enough (here n is the number of cells).
        int emptyRow = -1;
        for (int i = 0; i < n * n; ++i) {
            for (int j = i + 1; j < n * n; ++j) {
                if (this.grid[j / n][j % n] == 0) {
                    emptyRow = n - j / n;
                } else if (this.grid[i / n][i % n] > this.grid[j / n][j % n]) {
                    inversions++;
                }
            }
        }

        if (n % 2 == 1 && inversions % 2 == 0) {
            return true;
        }
        return n % 2 == 0 && emptyRow % 2 != inversions % 2;
    }
}
