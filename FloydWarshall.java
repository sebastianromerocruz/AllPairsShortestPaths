import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FloydWarshall extends AbstractAllPairsShortestPaths {

    private static final int DEFAULT_MAP_SIZE = 100;

    private final Map<Integer, int[][]> matrices;

    public FloydWarshall() {
        this(DEFAULT_MAP_SIZE);
    }

    public FloydWarshall(int mapSize) {
        this.matrices = new HashMap(mapSize);
    }

    public Map<Integer, int[][]> getMatrices() {
        return this.matrices;
    }

    @Override
    public int[][] getAllPairsShortestPaths(int[][] weights) throws InterruptedException {
        System.out.println("Getting all pairs shortest paths (Floyd-Warshall)...");
        Thread.sleep(2000L);

        int numberOfRows = weights.length;
        getMatrices().put(0, weights);

        for (int k = 0; k < numberOfRows; k++) {
            int[][] currentMatrix = new int[numberOfRows][numberOfRows];
            Thread.sleep(1000L);

            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfRows; j++) {
                    currentMatrix[i][j] = getMatrices().get(k)[i][j] <
                            (long) getMatrices().get(k)[i][k] + getMatrices().get(k)[k][j] ?
                            getMatrices().get(k)[i][j] : getMatrices().get(k)[i][k] + getMatrices().get(k)[k][j];
                }
            }
            System.out.printf("D(%d) =%n", k + 1);
            getPrinter().printMatrix(currentMatrix);
            getMatrices().put(k + 1, currentMatrix);
        }


        return getMatrices().get(numberOfRows);
    }
}