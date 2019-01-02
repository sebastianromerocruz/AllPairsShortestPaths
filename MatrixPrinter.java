import java.util.Arrays;

public class MatrixPrinter {

    public void printMatrix(int[][] matrix) {
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }

        System.out.println();
    }
}
