package util;

import solver.Solver;

import java.util.Random;

public class RandomizedTester {

    public static void main(String[] args) {
        Random r = new Random(1);
        int[][] grid = {
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 0}
        };
        long[] timesByMoveCount = new long[100];
        int[] countOfGridsByMoveCount = new int[100];
        int runs = 1000;
        if (args.length > 0) {
            runs = Integer.parseInt(args[0]);
        }
        while (runs > 0) {
            runs--;
            generateNextGrid(grid, r);
            long start = System.nanoTime();
            int moves = minimumCountOfMoves(grid);
            long end = System.nanoTime();
            if (moves == -1) {
                return;
            }
            timesByMoveCount[moves] += end - start;
            countOfGridsByMoveCount[moves]++;
        }

        for (int i = 1; i < 100; ++i) {
            System.out.println("Moves: " + i + " average time " + timesByMoveCount[i] / 1000000.0 / countOfGridsByMoveCount[i] + "ms");
        }

        for (int i = 1; i < 100; ++i) {
            System.out.println(i + ", " + timesByMoveCount[i] / 1000000.0 / countOfGridsByMoveCount[i]);
        }
    }

    public static void generateNextGrid(int[][] grid, Random r) {
        int[][] directions = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        int ex = -1, ey = -1;

        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ex = j;
                    ey = i;
                    break;
                }
            }
            if (ex != -1) {
                break;
            }
        }

        while (true) {
            int index = r.nextInt(4);
            int tx = ex + directions[index][0];
            int ty = ey + directions[index][1];

            if (!inside(ty, tx, n)) {
                continue;
            }

            grid[ey][ex] = grid[ty][tx];
            grid[ty][tx] = 0;
            break;
        }
    }

    private static boolean inside(int y, int x, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static int minimumCountOfMoves(int[][] grid) {
        Solver solver = new Solver(grid);
        if (!solver.isSolvable()) {
            return -1;
        }
        return solver.minimumMoveCount();
    }
}
