package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class Question1_Benchmark {
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

    public static void WQU_Alternative_Benchmark(final int N){
        WQU_Alternative wqu_alternative = new WQU_Alternative(N);
        Random random = new Random();

        while (wqu_alternative.getCount() != 1) {
            // generate two points
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if (!wqu_alternative.connected(p, q)) {
                wqu_alternative.union(p, q);
            }
        }

    }

    public static void main(String[] args) {
        Benchmark<Integer> benchmark_WQU_RUN = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQU_Benchmark(10000);
        });

        System.out.printf("N = 10000， weighted quick union size takes %.2f milliseconds\n",benchmark_WQU_RUN.run(0,1000));

        Benchmark<Integer> benchmark_WQU_ALTER_RUN = new Benchmark_Timer<>("WeightedUnionFindAlterRun 10000", black -> {
            WQU_Alternative_Benchmark(10000);
        });

        System.out.printf("N = 10000， weighted quick union depth takes %.2f milliseconds\n",benchmark_WQU_ALTER_RUN.run(0,1000));

    }
}
