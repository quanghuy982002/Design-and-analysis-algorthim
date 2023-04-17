package Hw4;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int binarySeach(int[] arr, int left, int right, int x) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (x == arr[mid]) {
            return mid;
        }
        if (x < arr[mid]) {
            return binarySeach(arr, left, mid - 1, x);
        }
        if (x > arr[mid]) {
            return binarySeach(arr, mid + 1, right, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        Arrays.sort(arr);
        int lef = 0;
        int right = arr.length - 1;
        int x = rand.nextInt();
        long startTime = System.currentTimeMillis();
        if (binarySeach(arr,lef,right,x) == -1 )
        {
            System.out.println("ERR!");
        }
        else
            System.out.println(binarySeach(arr,lef,right,x));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println();
        System.out.println("Thời gian chạy: " + totalTime + "ms");
    }
}
