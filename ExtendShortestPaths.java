import java.util.Arrays;

public class ExtendShortestPaths {

    public static final int INFINITY = Integer.MAX_VALUE;

    public int[][] extendShortestPaths(int[][] lArray, int[][] weights) {
        int nodeAmount = lArray.length;

        int[][] lArrayPrime = new int[nodeAmount][nodeAmount];

        for (int i = 0; i < nodeAmount; i++) {
            for (int j = 0; j < nodeAmount; j++) {
                lArrayPrime[i][j] = INFINITY;
                for (int k = 0; k < nodeAmount; k++) {
                    lArrayPrime[i][j] = lArrayPrime[i][j] < (long) lArray[i][k] + weights[k][j] ?
                            lArrayPrime[i][j] : lArray[i][k] + weights[k][j];
                }
            }
        }

        return lArrayPrime;
    }
}
