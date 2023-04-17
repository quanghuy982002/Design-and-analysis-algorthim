package hw4;

public class SumArrRecursive {
    public static int sumRecursive(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        else
            return arr[n - 1] + sumRecursive(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 3, 7, 8, 9};
        int sum = sumRecursive(arr, arr.length);
        System.out.println("Tổng của mảng là: " + sum);
    }
}