package io;

import solver.Solver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Input grid:");
        String line = s.nextLine();

        String[] nums = line.split(" ");
        int n = (int) Math.sqrt(nums.length);
        int[][] grid = new int[n][n];
        for (int i = 0; i < nums.length; ++i) {
            grid[i / n][i % n] = Integer.parseInt(nums[i]);
        }
        Solver solver = new Solver(grid);

        if (solver.isSolvable()) {
            int moves = solver.minimumMoveCount();
            System.out.println("This grid can be solved in " + moves + " moves");
        } else {
            System.out.println("This grid cannot be solved");
        }
    }
}