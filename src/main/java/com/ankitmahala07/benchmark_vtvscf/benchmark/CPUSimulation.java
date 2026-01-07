package com.ankitmahala07.benchmark_vtvscf.benchmark;

import java.util.concurrent.ThreadLocalRandom;

public class CPUSimulation {
    private static final int ARRAY_SIZE = 1024;

    public static long cpuTask(int seed) {
        long result = 0;
        int[] data = new int[ARRAY_SIZE];
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            data[i] = rnd.nextInt();
        }

        for (int i = 0; i < 200_000_000; i++) {
            int index = (int) ((i ^ seed) & (ARRAY_SIZE - 1));
            int value = data[index];

            if ((value & 1) == 0) {
                result += value * 31L;
            } else {
                result -= value * 17L;
            }

            data[index] = (int) result;
        }

        Blackhole.consume(result);
        return result;
    }
}
