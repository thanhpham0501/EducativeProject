package TwoPointers;

/**
 * Given an array, colors, which contains a combination of the following three elements:
 *  0 (representing red)
 *  1 (representing white)
 *  2 (representing blue)
 * Sort the array in place so that the elements of the same color are adjacent,
 * with the colors in the order of red, white, and blue.
 * To improve your problem-solving skills, do not utilize the built-in sort function.
 *
 *      Constraints: 1<= color.length <= 300
 *                  colors[i] can only contain 0s, 1s, or 2s
 *
 *      Solution Summary:
 *                      - Step 1: Traverse the array and swap elements, as required, to organize them correctly.
 *                      - Step 2: If the encountered color is red, swap its value with that of the start pointer.
 *                                If the color is blue, swap its value with that of end pointer.
 *                      - Step 3: White elements are skipped, and pointers are adjusted accordingly.
 *                      - Step 4: The array is sorted when the end pointer moves to the left of the current pointer.
 *
 *      Time complexity : O(n) since we're only traversing the array one.
 *
 *      Space complexity: O(1) since no extra space is used.
 *
 */
public class SortColors {
    public static int[] sortColors(int[] colors){
        // Initialize the start, current, and end pointers
        int start = 0;
        int current = 0;
        int end = colors.length - 1;
        // Iterate through the list until the current pointerr exceed the end pointer
        while (current <= end) {
            if (colors[current] == 0) {
                // if the current element is 0, swap it with the element at the start pointer
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                // Move both the start and current pointers one position forward
                current++;
                start++;
            } else if (colors[current] == 1) {
                // if current element is 1, move current pointer one position forward
                current ++;
            }
            else {
                // if the current element is 2, swap it with the element at the end pointer
                int temp = colors[current];
                colors[current] = colors[end];
                // move the end pointer one position backward
                end--;
            }
        }
        return colors;
    }
    public class Print {
        public static String arrayToString(int[] array) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        public static String repeat(String str, int times) {
            return str.repeat(times);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        // Iterate over the inputs and print the sorted array for each
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Print.arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Print.arrayToString(sortedColors));

            System.out.println(Print.repeat("-", 100));
        }
    }
}
