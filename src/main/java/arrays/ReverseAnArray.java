package arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int [] input = {131, 55, 11, 211, 312};
        System.out.println("Current array: ");
        ArraysUtil.printArray(input);
        System.out.println("\nReversed array: ");
        ArraysUtil.printArray(reverse(input));
    }


    private static int[] reverse(int[] input) {
        int length = input.length;
        int  temp;
        for (int i = 0; i < length/ 2; i++) {
            temp = input[i];
            input[i] = input[length - i - 1];
            input[length - i - 1] = temp;
        }
        return input;
    }

}
