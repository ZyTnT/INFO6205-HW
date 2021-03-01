package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class Question2_Benchmark {
    public static void WQU_Benchmark(final int N) {
        WQU wqu = new WQU(N);
        Random random = new Random();

        while (wqu.getCount() != 1) {
            // generate two points
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if (!wqu.connected(p, q)) {
                wqu.union(p, q);
            }
        }
    }

    public static void WQU_PathCompression_Benchmark(final int N){
        WQU_PathCompression wqu_pathCompression = new WQU_PathCompression(N);
        Random random = new Random();

        while (wqu_pathCompression.getCount() != 1) {
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if (!wqu_pathCompression.connected(p, q)) {
                wqu_pathCompression.union(p, q);
            }
        }

    }


    public static void main(String[] args) {
        Benchmark<Integer> benchmark_WQU_RUN = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQU_Benchmark(10000);
        });

        System.out.printf("Weigthed UnionFind(Size) to union 10000 sites takes %.2f milliseconds\n",benchmark_WQU_RUN.run(0,1000));

        Benchmark<Integer> benchmark_WQU_PathCompression_RUN = new Benchmark_Timer<>("WeightedUnionFindAlterRun 10000", black -> {
            WQU_PathCompression_Benchmark(10000);
        });

        System.out.printf("Weigthed UnionFind(PathCompression) to union 10000 sites takes %.2f milliseconds\n",benchmark_WQU_PathCompression_RUN.run(0,1000));

    }
}
