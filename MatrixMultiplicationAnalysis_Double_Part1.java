import java.util.Random;

public class MatrixMultiplicationAnalysis_Double_Part1 {

    public static void multiplyMatrix( int row1, int col1, double[][] matrixOne, int row2, int col2, double[][] matrixTwo ) {
        int i, j, k;

        if ( row2 != col1 ) {

            System.out.println("\nMultiplication of matrix is NOT Possible");
            return;
        }


        double[][] resultantMatrix = new double[row1][col2];

        for ( i = 0; i < row1; i++ ) {
            for ( j = 0; j < col2; j++ ) {
                for ( k = 0; k < row2; k++ )
                    resultantMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
            }
        }
    }

    public static double[][] RandomMatrixGen( int Row1, int Col1 ) {
        Random r = new Random();
        double[][] randomMatrix = new double[Row1][Col1];
        for ( int i = 0; i < Row1; i++ ) {
            for ( int j = 0; j < Col1; j++ ) {
                randomMatrix[i][j] = r.nextDouble();
            }
        }
        return randomMatrix;
    }

    public static void main( String[] args ) {
        int Row1 = 5000, Col1 = 80, Row2 = 80, Col2 = 4000;

        double[][] matrixOne;
        double[][] matrixTwo;

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