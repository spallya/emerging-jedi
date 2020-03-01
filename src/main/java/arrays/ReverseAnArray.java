package arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int [] input = {10, 20, 30, 40, 50};
        System.out.println("Current array: ");
        printArray(input);
        System.out.println("\nReversed array: ");
        printArray(reverse(input));
    }

    private static void printArray(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
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
