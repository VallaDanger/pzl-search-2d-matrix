package mx.chux.cs.pzl.matrix;

import java.util.logging.Level;
import java.util.logging.Logger;

import mx.chux.cs.pzl.Puzzle;
import mx.chux.cs.pzl.PuzzleExecutor;
import mx.chux.cs.pzl.TimedPuzzleSolution;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        final int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        Puzzle<Boolean> puzzle = Search2DMatrix.data(matrix, 20);
        PuzzleExecutor<Boolean> executor = PuzzleExecutor.from(puzzle);
        TimedPuzzleSolution<Boolean> solution = executor.executeTimed();

        LOGGER.log(Level.INFO, "Search2DMatrix [time: {0}],[ticks: {1}]: {2}", 
                new Object[] { solution.timeElapsed(), solution.ticks(), solution.get() });
        
        solution = executor.executeTimed(false);
        
        LOGGER.log(Level.INFO, "Search2DMatrix [time: {0}],[ticks: {1}]: {2}", 
                new Object[] { solution.timeElapsed(), solution.ticks(), solution.get() });
        
        puzzle = Search2DMatrix.data(matrix, 13);
        executor = PuzzleExecutor.from(puzzle);
        solution = executor.executeTimed();
        
        LOGGER.log(Level.INFO, "Search2DMatrix [time: {0}],[ticks: {1}]: {2}", 
                new Object[] { solution.timeElapsed(), solution.ticks(), solution.get() });

    }

}
