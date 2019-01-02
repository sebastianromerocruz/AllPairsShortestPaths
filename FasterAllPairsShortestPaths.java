import java.util.*;

public class FasterAllPairsShortestPaths extends AbstractAllPairsShortestPaths {

    @Override
    public int[][] getAllPairsShortestPaths(int[][] weights) throws InterruptedException {
        System.out.println("Getting all pairs shortest paths (optimised)...");
        Thread.sleep(1000L);

        int rowAmount = weights.length;
        int[][] l = weights;
        int m = 1;
        Map<Integer, int[][]> lMatrices = new HashMap(rowAmount);
        lMatrices.put(m, l);
        ExtendShortestPaths shortestPathsGenerator = new ExtendShortestPaths();

        while (m < rowAmount - 1) {
            int[][] currentMatrix = shortestPathsGenerator.extendShortestPaths(lMatrices.get(m), lMatrices.get(m));
            lMatrices.put(2 * m, currentMatrix);
            m *= 2;
        }

        return lMatrices.get(m);
    }
}
