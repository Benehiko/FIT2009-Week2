package SubsequenceSumProblem;

import org.junit.jupiter.api.Test;

class SubsequenceSumProblemTest {

    @org.junit.jupiter.api.Test
    void bruteForceAlgorithm() {
        SubsequenceSumProblem sum = new SubsequenceSumProblem();
        int[] input = {1, -3, 4, -2, -1, 6};

        // Measure execution time
        long startTime = System.nanoTime();

        sum.bruteForceAlgorithm(input);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Time taken to execute method:\n" + duration + " nano seconds\n"+ (duration/1000000d) + " milliseconds\n" + (duration/1000000000d) + " seconds\n");
    }

    @Test
    void quadraticAlgorithm() {
        SubsequenceSumProblem sum = new SubsequenceSumProblem();
        int[] input = {1, -3, 4, -2, -1, 6};

        // Measure execution time
        long startTime = System.nanoTime();

        sum.quadraticAlgorithm(input);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Time taken to execute method:\n" + duration + " nano seconds\n"+ (duration/1000000d) + " milliseconds\n" + (duration/1000000000d) + " seconds\n");

    }


    @Test
    void linearAlgorithm() {
        SubsequenceSumProblem sum = new SubsequenceSumProblem();
        int[] input = {1, -3, 4, -2, -1, 6};

        // Measure execution time
        long startTime = System.nanoTime();

        sum.linearAlgorithm(input);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Time taken to execute method:\n" + duration + " nano seconds\n"+ (duration/1000000d) + " milliseconds\n" + (duration/1000000000d) + " seconds\n");
    }
}
