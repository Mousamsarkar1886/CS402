import java.util.Random;

public class MatrixMultiplicationAnalysis_Integer_Part2 {

    public static void multiplyMatrix( int row1, int col1, int[][] matrixOne, int row2, int col2, int[][] matrixTwo ) {
        int i, j, k;

        if ( row2 != col1 ) {

            System.out.println("\nMultiplication of matrix is NOT Possible");
            return;
        }


        int[][] resultantMatrix = new int[row1][col2];

        for ( i = 0; i < col2; i++ ) {
            for ( j = 0; j < row1; j++ ) {
                for ( k = 0; k < col1; k++ ) {
                    resultantMatrix[j][i] += matrixOne[j][k] * matrixTwo[k][i];
                }
            }
        }
    }

    public static int[][] RandomMatrixGen( int Row, int Col ) {
        Random r = new Random();
        int[][] randomMatrix = new int[Row][Col];
        for ( int i = 0; i < Row; i++ ) {
            for ( int j = 0; j < Col; j++ ) {
                randomMatrix[i][j] = r.nextInt(9);
            }
        }
        return randomMatrix;
    }

    public static void main( String[] args ) {
        int Row1 = 5000, Col1 = 80, Row2 = 80, Col2 = 4000;

        int[][] matrixOne;
        int[][] matrixTwo;

        for ( int i = 0; i < 10; i++ ) {
            long startTime = System.nanoTime();

            matrixOne = RandomMatrixGen(Row1, Col1);
            matrixTwo = RandomMatrixGen(Row2, Col2);
            multiplyMatrix(Row1, Col1, matrixOne, Row2, Col2, matrixTwo);

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println(+timeElapsed / 1000000);
        }

//        System.out.println("Execution time in nanoseconds: " + timeElapsed);
//        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
//        System.out.println("Execution time in seconds: " + timeElapsed / 1000000000);
    }
}


