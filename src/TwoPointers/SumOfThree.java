package TwoPointers;
// Given an array of integers, numbs, and an integer value, target, determine if there are any three integers in nums
// whose sum is equal to the target, that is, numbs[i] + numbs[j] + numbs[k] == target.
// Return TRUE if three such integers exist in the array. Otherwise, return FALSE.

// note : A valid triplet consists of elements with distinct indexes
// This means, for the triplet numbs[i], numbs[j], and numbs[k], i != j , j != k , i != k

import java.util.*;

public class SumOfThree {

    public static boolean findSumOfThree(int[] numbs, int target){
        // Sort the array in ascending order
        Arrays.sort(numbs);
        // Store the current array element and set up two pointers (low and high)
        // to find the other two elements that complete the required triplet.
        int low, high, sum;
        for (int i = 0; i < numbs.length - 2; i++){
            low = i + 1; // the low pointer is set to the current loop's index + 1
            high = numbs.length - 1; // the high is set to the last index of the array
            while (low < high) {
                sum = numbs[i] + numbs[low] + numbs[high]; // Calculate the sum of array elements pointed to by the current loop’s index and the low and high pointers.
                if (sum == target) {
                    return true; // If the sum is equal to target, return TRUE.
                } else if (sum < target) {
                    low++; //If the sum is less than target, move the low pointer forward.
                } else {
                    high--; // If the sum is greater than target, move the high pointer backward.
                }
            }
        }
        //Repeat until the loop has processed the entire array.
        // If, after processing the entire array, we don’t find any triplet that matches our requirement,
        // we return FALSE.
        return false;
    }

    public static void main(String[] args) {
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};

        int[] testList = {10, 7, 20, -1, 8};


        for (int i=0; i<testList.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            if (findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}

/**
 * Time Complexity:
     * Sorting the array takes O(nlog(n)) and the loop take O(n^2) to find the triplet. Here, n is the number
     * of elements in the input array.
     * Therefore, the total time complexity of this solution is O(nlog(n) + n^2) --> simplifies to O(n^2)
 *
 * Space Complexity:
    * Because we use the built-in Java function, Arrays.sort(),
    * so the space complexity of the provided solution is O(log(n))

 */