package interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MazeSolveTest {
    private MazeSolve maze;

    @BeforeEach
    void beforeEach() {
        maze = new MazeSolve();
    }

    @Test
    void itSolvesASmallMaze() {
        char[][] M = {
                { 'G' }
        };
        assertTrue(maze.solve(M, 0, 0));
    }

    @Test
    void itSolvesALargeMaze() {
        char[][] M = {
                { '#', '#', '#', '#', '#', '#', '#' },
                { '#', 'G', '#', ' ', '#', ' ', '#' },
                { '#', ' ', '#', ' ', '#', ' ', '#' },
                { '#', ' ', ' ', ' ', '#', ' ', '#' },
                { '#', '#', '#', ' ', ' ', ' ', '#' },
                { '#', ' ', ' ', ' ', '#', '#', '#' },
                { '#', ' ', '#', ' ', ' ', ' ', '#' },
                { '#', '#', '#', '#', '#', '#', '#' }
        };
        assertTrue(maze.solve(M, 6, 1));
    }

    @Test
    void itDoesNotSolveAMazeWithoutAGoal() {
        char[][] M = {
                { ' ', '+', ' ' },
                { '#', ' ', '#' },
                { ' ', '+', ' ' }
        };
        assertFalse(maze.solve(M, 1, 1));
    }
}
