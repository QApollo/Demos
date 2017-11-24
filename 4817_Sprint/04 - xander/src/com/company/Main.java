package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Random r = new Random();

    public static void main(String[] args) {
        ExecutorService service = null;

        double start = System.currentTimeMillis();
        int[] sortedArray = bogoSortOneThread();

        double end = (System.currentTimeMillis() - start)/1000;
        System.out.println("normal" + " " + Arrays.toString(sortedArray) + end);


        try {
            service = Executors.newCachedThreadPool();
            List<Callable<int[]>> callables = Arrays.asList(
                initizalizeBogosort(),
                initizalizeBogosort(),
                initizalizeBogosort(),
                initizalizeBogosort(),
                initizalizeBogosort()
                );

            start = System.currentTimeMillis();
           int[] firstSortedArray = service.invokeAny(callables);
           service.shutdownNow();

           end = (System.currentTimeMillis() - start)/1000;
           System.out.println("Parallel first result" + " " + Arrays.toString(firstSortedArray) + end);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            if (service != null) {
                service.shutdown();
                }
            }
        }


    private static Callable<int[]> initizalizeBogosort() {
        return () -> {
            int[] unsorted = new int[10];
            for (int i = 0; i < unsorted.length; i++) {
                unsorted[i] = r.nextInt(10000);
            }

            int[] sorted = Bogosort.sort(unsorted);
            Thread.sleep(1);
            return sorted;
        };
    }

    private static int[] bogoSortOneThread() {
        int[] unsorted = new int[10];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = r.nextInt(10000);
        }

        int[] sorted = Bogosort.sort(unsorted);
        return sorted;
    }

}
