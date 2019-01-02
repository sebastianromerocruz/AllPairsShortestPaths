import java.util.ArrayList;
import java.util.List;

public class SlowAllPairsShortestPaths extends AbstractAllPairsShortestPaths {

    public static void main(String[] args) throws InterruptedException {
        AllPairsShortestPaths slowAllPairsShortestPaths = new SlowAllPairsShortestPaths();
        AllPairsShortestPaths fasterAllPairsShortestPaths = new FasterAllPairsShortestPaths();

        int inf = ExtendShortestPaths.INFINITY;

        int[][] weights = new int[][] {
                { 0,    inf,  inf,  inf,  -1,  inf },
                { 1,    0,    inf,  2,    inf, inf },
                { inf,  2,    0,    inf,  inf, -8  },
                { -4,   inf,  inf,  0,    3,   inf },
                { inf,  7,    inf,  inf,  0,   inf },
                { inf,  5,    10,   inf,  inf, 0   }
        };

        AllPairsShortestPaths floydWarshall = new FloydWarshall(weights.length);

        System.out.println("L(1) =");
        PRINTER.printMatrix(weights);

//        PRINTER.printMatrix(slowAllPairsShortestPaths.getAllPairsShortestPaths(weights));
//        PRINTER.printMatrix(fasterAllPairsShortestPaths.getAllPairsShortestPaths(weights));
        floydWarshall.getAllPairsShortestPaths(weights);

    }

    @Override
    public int[][] getAllPairsShortestPaths(int[][] weights) throws InterruptedException {
        System.out.println("Getting all pairs shortest paths (slow)...");
        Thread.sleep(2500L);

        int nodeAmount = weights.length;
        int[][] l = weights;

        List<int[][]> lMatrices = new ArrayList<>(nodeAmount);
        lMatrices.add(0, l);

        ExtendShortestPaths shortestPathGenerator = new ExtendShortestPaths();

        for (int m = 1; m < nodeAmount - 1; m++) {
            int[][] currentLMatrix = shortestPathGenerator.extendShortestPaths(lMatrices.get(m - 1), weights);
            lMatrices.add(m, currentLMatrix);
        }

        return lMatrices.get(nodeAmount - 2);
    }
}
