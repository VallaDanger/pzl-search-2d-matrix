package mx.chux.cs.pzl.matrix;

import mx.chux.cs.pzl.Puzzle;

public class Search2DMatrix extends Puzzle<Boolean> {

    public static Search2DMatrix data(final int[][] matrix, final int target) {
        return new Search2DMatrix(matrix, target);
    }

    private final int[][] matrix;
    
    private final int rows;
    private final int cols;
    
    final int target;

    private Search2DMatrix(final int[][] matrix, final int target) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.target = target;
    }

    @Override
    public Boolean bruteForceSolution() {
        for( int row = 0 ; row < this.rows ; row++ ) {
            for( int col = 0 ; col < this.cols ; col++ ) {
                tick();
                if( this.target == get(row, col) ) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean optimalSolution() {
        // time complexity: O(R+C)
        
        if( this.rows == 0 ) {
            return Boolean.FALSE;
        }
        
        // matrix is sorted:
        // ascending from left to right
        // ascending from top to bottom
        
        // start from top right
        int row = 0;
        int col = this.cols-1;
        
        while( (row < this.rows) && (col >= 0) ) {
            
            tick();
            
            final int value = get(row, col);
            
            if( value == this.target ) {
                return Boolean.TRUE;
            }
            else if( this.target > value ) {
                // if target is greater than current element
                // then it cannot be to its left, it must be
                // further towards the bottom of current column
                row += 1;
            } else {
                // if target is lesser than current element
                // then it cannot be towards bottom, it must be
                // further towards the left of the current row.
                col -= 1;
            }
        }
        
        return Boolean.FALSE;
    }
    
    private int get(final int row, final int col) {
        return this.matrix[row][col];
    }

}
