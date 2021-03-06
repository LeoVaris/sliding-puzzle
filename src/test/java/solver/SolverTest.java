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
        assertEquals(9, solver.minimumMoveCount());
        IntegerList list = solver.getBestPath(9);
        int[] solution = { 4, 8, 2, 3, 5, 6, 8, 5, 6 };
        assertEquals(9, list.size());
        for (int i = 0; i < 9; ++i) {
            assertEquals(solution[i], list.get(i));
        }
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
        assertEquals(-1, solver.minimumMoveCount());
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

    @Test
    public void testManhattanDistance() {
        int[][] grid = {
                {1, 2},
                {3, 0}
        };
        Solver solver = new Solver(grid);
        assertEquals(0, solver.manhattanDistance());
    }

    @Test
    public void testManhattanDistance2() {
        int[][] grid = {
                {3, 2},
                {0, 1}
        };
        Solver solver = new Solver(grid);
        assertEquals(3, solver.manhattanDistance());
    }

    @Test
    public void testManhattanDistance3() {
        int[][] grid = {
                {3, 2},
                {2, 1}
        };
        Solver solver = new Solver(grid);
        assertEquals(5, solver.manhattanDistance());
    }

    @Test
    public void testInside() {
        int[][] grid = {
                {3, 2},
                {2, 1}
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.inside(0, 0));
        assertFalse(solver.inside(-1, 0));
        assertFalse(solver.inside(0, -1));
        assertFalse(solver.inside(2, 0));
        assertFalse(solver.inside(0, 2));
    }

    @Test
    public void testMinimumMoveCount() {
        int[][] grid = {
                { 1, 8, 2 },
                { 0, 4, 3 },
                { 7, 6, 5 }
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.minimumMoveCount() > 0);
    }

    @Test
    public void testMinimumMoveCount2() {
        int[][] grid = {
                { 0, 8, 2 },
                { 1, 4, 3 },
                { 7, 6, 5 }
        };
        Solver solver = new Solver(grid);
        assertEquals(solver.minimumMoveCount(), solver.manhattanDistance());
    }

    @Test
    public void testMinimumMoveCount3() {
        int[][] grid = {
                {8, 0, 2},
                {1, 4, 3},
                {7, 6, 5}
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.minimumMoveCount() > 0);
    }

    @Test
    public void testMinimumMoveCount4() {
        int[][] grid = {
                {0, 1, 2},
                {5, 8, 4},
                {6, 3, 7},
        };
        Solver solver = new Solver(grid);
        assertTrue(solver.minimumMoveCount() > 0);
    }
}
