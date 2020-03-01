package arrays;

import java.util.Arrays;

public class KthSmallest {

    public static int kthSmallest(int[] input, int k) {
        Arrays.sort(input);
        return input[k - 1];
    }

    public static void main(String[] args) {
        int input[] = {141, 34, 890, 3, 121, 53, 1};
        int k = 2;
        System.out.println("Current array: ");
        ArraysUtil.printArray(input);
        System.out.print("\nK'th smallest element is " + kthSmallest(input, k) + " where k = " + k);
    }
}
