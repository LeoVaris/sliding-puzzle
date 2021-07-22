package solver;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void testIsSolvable1() {
        int[][] grid = {
            { 1, 8, 2 },
            { 0, 4, 3 },
            { 7, 6, 5 }
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.isSolvable());
    }

    @Test
    public void testIsSolvable2() {
        int[][] grid = {
                { 1, 8, 2 },
                { 0, 4, 3 },
                { 7, 5, 6 }
        };
        Solver solver = new Solver(grid);
        assertFalse(solver.isSolvable());
    }

    @Test
    public void testIsSolvable3() {
        int[][] grid = {
                {6, 13, 7, 10},
                {8, 9, 11, 0},
                {15, 2, 12, 5},
                {14, 3, 1, 4},
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.isSolvable());
    }

    @Test
    public void testIsSolvable4() {
        int[][] grid = {
                {3, 9, 1, 15},
                {14, 11, 4, 6},
                {13, 0, 10, 12},
                {2, 7, 8, 5},
        };
        Solver solver = new Solver(grid);
        assertFalse(solver.isSolvable());
    }

    @Test
    public void testIsSolvable5() {
        int[][] grid = {
                {13, 2, 10, 3},
                {1, 12, 8, 4},
                {5, 0, 9, 6},
                {15, 14, 11, 7},
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.isSolvable());
    }
}
