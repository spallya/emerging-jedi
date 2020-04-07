package heaps;

public class MaxHeap {

    static boolean isHeap(int arr[], int i, int n) {
        if(i < (n-2)/2)
            return true;
        if(arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2] &&
             isHeap(arr, 2*i+1, n) && isHeap(arr, 2*i+2, n))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {20, 15, 10, 7, 12, 2, 7, 3};
        int n = arr.length - 1;
        if(isHeap(arr, 0, n)){
            System.out.println("It's a Max heap");
        } else {
            System.out.println("It's not a Max Heap");
        }
    }
}