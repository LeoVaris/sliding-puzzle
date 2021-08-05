package solver;

/**
 * This class is the main solver for the puzzle.
 */
public class Solver {
    int[][] grid;
    final int infinity = 1000 * 1000;

    /**
     * @param grid The input to the puzzle. Input should be an n * m array of integers from 0 to n * m - 1. The empty square should be given as a zero.
     */
    public Solver(int[][] grid) {
        this.grid = grid;
    }

    /**
     * @return Whether the puzzle can be solved
     */
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

    /**
     * @param y Y coordinate
     * @param x X coordinate
     * @return The manhattan distance of the number at X, Y to its target square.
     */
    public int manhattanDistance(int y, int x) {
        int value = this.grid[y][x] - 1;
        return Math.abs(x - (value % this.grid[0].length)) + Math.abs(y - (value / this.grid.length));
    }

    /**
     * @return The manhattan distance of the current grid.
     */
    public int manhattanDistance() {
        int ans = 0;
        int n = this.grid.length;
        int m = this.grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (this.grid[i][j] != 0) {
                    ans += this.manhattanDistance(i, j);
                }
            }
        }
        return ans;
    }

    /**
     * @return The minimum count of moves to solve the current grid. Should be used only if grid is solvable.
     */
    public int minimumMoveCount() {
        int startDistance = this.manhattanDistance();
        int bound = startDistance;
        int emptyX = -1, emptyY = -1;
        int n = this.grid.length;
        int m = this.grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (this.grid[i][j] == 0) {
                    emptyX = j;
                    emptyY = i;
                }
            }
        }
        int minCost = this.search(0, startDistance, emptyY, emptyX, bound);
        while (minCost > bound) {
            bound = minCost;
            minCost = this.search(0, startDistance, emptyY, emptyX, bound);
        }
        return minCost;
    }

    /**
     * @return Whether the current grid is solved.
     */
    public boolean solved() {
        int n = this.grid.length;
        int m = this.grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (this.grid[i][j] != 0 && this.grid[i][j] != i * m + j + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param y Y coordinate
     * @param x X coordinate
     * @return Whether the X, Y coordinates are inside the grid, i.e 0 <= X < m and 0 <= Y < n.
     */
    public boolean inside(int y, int x) {
        int n = this.grid.length;
        int m = this.grid[0].length;
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int search(int moves, int distance, int emptyY, int emptyX, int bound) {
        if (moves + distance > bound) {
            return moves + distance;
        }
        if (this.solved()) {
            return moves;
        }
        int[][] directions = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        int minDistance = this.infinity;

        for (int[] dir : directions) {
            int tx = emptyX + dir[0];
            int ty = emptyY + dir[1];
            if (!this.inside(ty, tx)) {
                continue;
            }

            int currentDistance = this.manhattanDistance(ty, tx);
            this.grid[emptyY][emptyX] = this.grid[ty][tx];

            this.grid[ty][tx] = 0;

            int newDistance = this.manhattanDistance(emptyY, emptyX);

            minDistance = Math.min(minDistance, this.search(moves + 1, distance - currentDistance + newDistance, ty, tx, bound));

            this.grid[ty][tx] = this.grid[emptyY][emptyX];
            this.grid[emptyY][emptyX] = 0;
        }

        return minDistance;
    }
}
