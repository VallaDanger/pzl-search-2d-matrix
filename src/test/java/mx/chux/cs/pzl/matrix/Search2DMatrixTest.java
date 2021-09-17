package mx.chux.cs.pzl.matrix;

import org.junit.BeforeClass;
import org.junit.Test;

import mx.chux.cs.pzl.PuzzleExecutor;
import mx.chux.cs.pzl.TimedPuzzleSolution;
import mx.chux.cs.pzl.Puzzle;

import static org.assertj.core.api.Assertions.*;

public class Search2DMatrixTest {

    private static int[][] matrix;

    @BeforeClass
    public static void init() {
        matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    }

    private void assertSolution(final int value, final boolean expectedSolution, final int ticks) {
        final Puzzle<Boolean> puzzle = Search2DMatrix.data(matrix, value);
        final PuzzleExecutor<Boolean> executor = PuzzleExecutor.from(puzzle);
        final TimedPuzzleSolution<Boolean> solution = executor.executeTimed();
        assertThat(solution.get()).isEqualTo(Boolean.valueOf(expectedSolution));
        assertThat(solution.ticks()).isEqualTo(ticks);
    }

    @Test
    public void foundTest() {
        assertSolution(13, true, 7);
    }

    @Test
    public void notFoundTest() {
        assertSolution(20, false, 4);
    }

}
