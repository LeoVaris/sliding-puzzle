package util;

import solver.Solver;

public class Tester {
    long[] timesByMoveCount;
    int[] countOfGridsByMoveCount;
    int[][] grid;
    int totalCountOfGrids;
    boolean[] reserved;
    int n, m;

    public Tester() {
        this.n = 3;
        this.m = 3;
        this.totalCountOfGrids = 0;
        this.timesByMoveCount = new long[100];
        this.grid = new int[n][m];
        this.reserved = new boolean[n * m];
        this.countOfGridsByMoveCount = new int[100];

        this.runPermutations(0);

        for (int i = 1; i <= 100; ++i) {
            System.out.print("Moves: " + i + " average time " + this.timesByMoveCount[i] / 1000000.0 / this.countOfGridsByMoveCount[i] + "ms");
        }
    }

    private long factorial(long num) {
        long ans = 1;
        for (long i = 2; i <= num; ++i) {
            ans *= i;
        }
        return ans;
    }

    public void runPermutations(int pos) {
        if (pos == n * m) {
            // Run test
            long start = System.nanoTime();
            int moves = this.minimumCountOfMoves(this.grid);
            long end = System.nanoTime();
            if (moves == -1) return;
            this.timesByMoveCount[moves] += end - start;
            this.countOfGridsByMoveCount[moves]++;
            this.totalCountOfGrids++;
            if (this.totalCountOfGrids % 10 == 0) {
                System.out.println("Tested " + this.totalCountOfGrids + "/" + (this.factorial((long) this.n * this.m)));
            }
            return;
        }
        for (int i = 0; i < n * m; ++i) {
            if (this.reserved[i]) continue;
            this.reserved[i] = true;
            this.grid[pos / m][pos % n] = i;
            this.runPermutations(pos + 1);
            this.reserved[i] = false;
        }
    }

    public int minimumCountOfMoves(int[][] grid) {
        Solver solver = new Solver(grid);
        if (!solver.isSolvable()) return -1;
        return solver.minimumMoveCount();
    }
}
