package io;

import solver.Solver;
import solver.IntegerList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Input grid:");
        String line = s.nextLine();

        String[] nums = line.split(" ");
        int n = (int) Math.sqrt(nums.length);
        if (n * n != nums.length) {
            System.out.println("Please input a valid grid");
            return;
        }
        int[][] grid = new int[n][n];
        for (int i = 0; i < nums.length; ++i) {
            grid[i / n][i % n] = Integer.parseInt(nums[i]);
        }
        Solver solver = new Solver(grid);

        if (solver.isSolvable()) {
            int moves = solver.minimumMoveCount();
            IntegerList bestPath = solver.getBestPath(moves);
            System.out.println("This grid can be solved in " + moves + " moves");
            System.out.println("Sequence of moves to solve the grid: ");
            printGrid(grid);
            for (int i = 0; i < bestPath.size(); ++i) {
                performMove(grid, bestPath.get(i));
                System.out.println("-------");
                printGrid(grid);
            }
        } else {
            System.out.println("This grid cannot be solved");
        }
    }

    public static void printGrid(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void performMove(int[][] grid, int move) {
        int n = grid.length;

        int[][] directions = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0) {
                    continue;
                }
                for (int[] dir : directions) {
                    int tx = j + dir[0];
                    int ty = i + dir[1];
                    if (!(tx >= 0 && ty >= 0 && tx < n && ty < n)) {
                        continue;
                    }
                    if (grid[ty][tx] != move) {
                        continue;
                    }

                    grid[i][j] = grid[ty][tx];
                    grid[ty][tx] = 0;
                    return;
                }
            }
        }
    }
}