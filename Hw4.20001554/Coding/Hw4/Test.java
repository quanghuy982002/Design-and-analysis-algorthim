package Hw4;

import java.util.Arrays;
import java.util.Random;

public class Test {
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
        Random rand = new Random();
        long startTime, endTime, totalTime;

        for (int i = 1; i <= 10; i++) {
            int[] arr = new int[(int) Math.pow(10, i)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt();
            }
            Arrays.sort(arr);
            int lef = 0;
            int right = arr.length - 1;
            int x = rand.nextInt();
            startTime = System.nanoTime();
            if (binarySeach(arr, lef, right, x) == -1) {
                System.out.println("ERR!");
            } else {
                System.out.println(binarySeach(arr, lef, right, x));
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Size of array: " + Math.pow(10, i));
            System.out.println("Time taken: " + totalTime + "ns");
            System.out.println();
        }
    }
}