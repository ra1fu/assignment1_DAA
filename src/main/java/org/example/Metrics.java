package org.example;

public class Metrics {
    private static long comparisons = 0;
    private static long allocations = 0;
    private static long maxDepth = 0;
    private static final ThreadLocal<Long> currentDepth = ThreadLocal.withInitial(() -> 0L);

    private static long startTime;
    private static long elapsedTime;

    public static void reset() {
        comparisons = 0;
        allocations = 0;
        maxDepth = 0;
        currentDepth.set(0L);
        elapsedTime = 0;
    }

    public static void startTimer() {
        startTime = System.nanoTime();
    }

    public static void stopTimer() {
        elapsedTime = System.nanoTime() - startTime;
    }

    public static void incComparisons() {
        comparisons++;
    }

    public static void incAllocations() {
        allocations++;
    }

    public static void enterRecursion() {
        long d = currentDepth.get() + 1;
        currentDepth.set(d);
        if (d > maxDepth) maxDepth = d;
    }

    public static void exitRecursion() {
        currentDepth.set(currentDepth.get() - 1);
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static long getAllocations() {
        return allocations;
    }

    public static long getMaxDepth() {
        return maxDepth;
    }

    public static long getElapsedTimeMs() {
        return elapsedTime / 1_000_000;
    }
}
