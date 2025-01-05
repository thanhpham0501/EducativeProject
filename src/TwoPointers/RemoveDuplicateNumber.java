package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateNumber {
    public static List<Integer> duplicateNumber (int[] sortedArr) {
        //create a new array
        List<Integer> ls = new ArrayList<>();
        if(sortedArr == null || sortedArr.length == 0) return ls;
        // initialize 2 pointers
        int previous = 0;
        int current = 1;
        while (current != sortedArr.length) {
            if(sortedArr[current] != sortedArr[previous]) {
                ls.add(sortedArr[current]);
            }
            previous = current;
            current++;
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,4,5,6,7,8,8,10,10,12,12,15};
        List<Integer> output = duplicateNumber(input);
        // Print output
        for (int item: output) {
            System.out.print(item + ", ");
        }
    }

}
