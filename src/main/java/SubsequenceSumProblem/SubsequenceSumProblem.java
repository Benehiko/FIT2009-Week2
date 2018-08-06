package SubsequenceSumProblem;

/**
 * The Maximum Contiguous Subsequence Sum Problem:
 * Given (possibly negative as well) a sequence of integers A0, A1, …, AN – 1 ,
 * find (and identify the subsequence corresponding to) the maximum value of Ai + Ai+1 + … + Aj where 0 ≤ i ≤ j < N.
 *
 * An empty set containing no integers of the sequence is also considered as a subsequence with sum of 0
 * So, the maximum contiguous subsequence sum is 0 if all the integers are negative.
 *
 * Example:
 * 1, -3, 4, -2, -1, 6  = The Sum ( 7 ) = The Subsequence ( 4, -2, -1, 6 )
 * -5, -2, -8  =  The Sum ( 0 ) = The Subsequence ( The empty set )
 *
 */
public class SubsequenceSumProblem {


    /**
     * Creating an O(N^3) (cubic algorithm) notation since we are using 3 loops (nested)
     * Please note this is an example from Week 2 Slides, slide 13
     * This is an algorithm to find the numbers inside a sequence which would yield the maximum sum (greatest sum number).
     * The input is going to be an array
     * @param input
     */
    public void bruteForceAlgorithm(int[] input){



        // The maximum sum
        int maxSum = 0;
        int seqStart = 0;
        int seqEnd = 0;

        // Keep track of our outer loop information
        StringBuilder outerInfo = new StringBuilder();

        // Keep track of our inner loop information
        StringBuilder innerInfo = new StringBuilder();
        int innerCounter = 0;

        // Keep track of our most inner loop information
        StringBuilder innerMostInfo = new StringBuilder();
        int innerMostCounter = 0;

        StringBuilder sumEvolution = new StringBuilder();


        // Loop over the full length of our array
        for ( int i = 0; i < input.length; i++){
            outerInfo.append("Outer Loop Round: | ").append(i).append(" -> ").append(input[i]).append("\n");

            innerInfo.append("\nBatchInner Counter: ").append(innerCounter);
            // Loop over the full length of our array as an inner loop. This will execute a total of input.length
            for (int j=0; j < input.length; j++){

                innerInfo.append("\nInner Loop Round: | ").append(j).append(" -> ").append(input[j]).append("\n");

                // Declare the temporary linear sum variable
                int linearSum = 0;

                innerMostInfo.append("\nBatch InnerMostLoop Counter: ").append(innerMostCounter);
                for (int k=i; k<=j; k++){

                        innerMostInfo.append("\nInner Most Loop: | ").append(k).append("->").append(input[k]);


                        linearSum += input[k]; // Get the K-th element.

                }

                innerMostCounter++;

                if (linearSum > maxSum){
                    maxSum = linearSum;
                    sumEvolution.append("\nSum Evolution: ").append(maxSum);
                    seqStart = i;
                    seqEnd = j;
                }


            }
            innerCounter++;
        }

        System.out.println(outerInfo.toString());
        System.out.println(innerInfo.toString());
        System.out.println(innerMostInfo.toString());
        System.out.println(sumEvolution.toString());
        System.out.println("Max Sum " + maxSum);
        System.out.println("Best Sequence: Start:" + seqStart + " - End:"+seqEnd);
    }

    /**
     * Creating an O(N^2) (quadratic algorithm) notation since we are using 2 loops (nested)
     * @param input
     */
    public void quadraticAlgorithm(int[] input){

        int maxSum = 0;
        int seqStart = 0;
        int seqEnd = 0;

        for(int i=0; i<input.length; i++){
            int linearSum = 0;

            for (int j = i; j < input.length; j++){
                linearSum += input[j];

                if (linearSum > maxSum){
                    maxSum = linearSum;
                    seqStart = i;
                    seqEnd = j;
                }
            }
        }

        System.out.println("Max Sum" + maxSum);
        System.out.println("Best Sequence: Start:" + seqStart + " - End:"+seqEnd);
    }

    /**
     * Normal O(N) (linear) algorithm since there is only 1 loop.
     *
     *             Notice how (i) isn't incremented by the for loop.
     *             i will be 0 and will stay 0 until linearSum is negative.
     *
     *             The reason for this is since we are only using 1 loop we need to "skip" the values that won't be useful in
     *             our subsequence sum. Thus we make linearSum = 0 to reset it. 
     *             eg. 1, -3, 4, -2, -1, 6
     *             1 + (-3) - > bam , j is negative.
     *             set i to j + 1 ...  i = 2, j = 1
     *
     *             continue loop...
     *
     *             4 + (-2) + (-1) + 6 = 7
     *
     *             History of maxSum:
     *             1, 4, 7
     *
     *             Positions for Best Sequence
     *             Start:(i) 2 - End:(j) 5
     *
     * @param input
     */
    public void linearAlgorithm(int[] input){

        StringBuilder maxEvolution = new StringBuilder();

        int maxSum = 0;
        int seqStart = 0;
        int seqEnd = 0;

        int linearSum = 0;
        maxEvolution.append("Max Evolution :");
        for (int i=0, j=0; j < input.length; j++){

            linearSum += input[j];

            if (linearSum > maxSum){
                maxSum = linearSum;
                maxEvolution.append(maxSum).append(",");
                seqStart = i;
                seqEnd = j;
            }else if (linearSum < 0){
                // Reset the linear sum if linear sum is negative and make i
                i = j + 1;
                linearSum = 0;

            }

        }

        System.out.println("Best Sequence: Start:"+ seqStart + " - End:"+seqEnd);
        System.out.println("Max Sum: "+maxSum);
        System.out.println("Max Evolution: "+maxEvolution.toString());
    }
}
