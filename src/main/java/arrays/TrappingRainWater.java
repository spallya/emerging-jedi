package arrays;

/*
* Leetcode Result
* Runtime: 1 ms, faster than 92.29% of Java online submissions for Trapping Rain Water.
* Memory Usage: 38.9 MB, less than 47.26% of Java online submissions for Trapping Rain Water.
* */
public class TrappingRainWater {

    public static void main(String[] args) {
        int input[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Current array: ");
        ArraysUtil.printArray(input);
        System.out.print("\nTrapped water is " + calculateTrappedWater(input));
    }

    private static int calculateTrappedWater(int[] height) {
        int length = height.length;
        int trappedWater = 0;
        if (length > 0) {
            int[] leftMax = new int[length];
            int[] rightMax = new int[length];
            leftMax[0] = height[0];
            for (int i = 1; i < length; i++) {
                leftMax[i] = max(height[i], leftMax[i - 1]);
            }
            rightMax[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                rightMax[i] = max(height[i], rightMax[i + 1]);
            }
            for (int i = 1; i < length - 1; i++) {
                trappedWater += min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return trappedWater;
    }

    private static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    private static int min(int a, int b) {
        return (a <= b) ? a : b;
    }
}
