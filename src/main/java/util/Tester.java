package util;

import solver.Solver;

import java.util.Arrays;

public class Tester {
    static long[] timesByMoveCount;
    static int[] countOfGridsByMoveCount;
    static int[][] grid;
    static int totalCountOfGrids;
    static boolean[] reserved;
    static int n, m;

    public static void main(String[] args) {
        n = 3;
        m = 3;
        totalCountOfGrids = 0;
        timesByMoveCount = new long[100];
        grid = new int[n][m];
        reserved = new boolean[n * m];
        countOfGridsByMoveCount = new int[100];

        runPermutations(0);

        for (int i = 1; i < 100; ++i) {
            System.out.println("Moves: " + i + " average time " + timesByMoveCount[i] / 1000000.0 / countOfGridsByMoveCount[i] + "ms");
        }
    }

    private static long factorial(long num) {
        long ans = 1;
        for (long i = 2; i <= num; ++i) {
            ans *= i;
        }
        return ans;
    }

    public static void runPermutations(int pos) {
        if (pos == n * m) {
            // Run test
            long start = System.nanoTime();
            int moves = minimumCountOfMoves(grid);
            long end = System.nanoTime();
            if (moves == -1) {
                return;
            }
            timesByMoveCount[moves] += end - start;
            countOfGridsByMoveCount[moves]++;
            totalCountOfGrids++;
            if (totalCountOfGrids % 10 == 0) {
                System.out.println("Tested " + totalCountOfGrids + "/" + (factorial((long) n * m)));
            }
            return;
        }
        for (int i = 0; i < n * m; ++i) {
            if (reserved[i]) {
                continue;
            }
            reserved[i] = true;
            grid[pos / n][pos % m] = i;
            runPermutations(pos + 1);
            reserved[i] = false;
        }
    }

    public static int minimumCountOfMoves(int[][] grid) {
        Solver solver = new Solver(grid);
        if (!solver.isSolvable()) {
            return -1;
        }
        return solver.minimumMoveCount();
    }
}
