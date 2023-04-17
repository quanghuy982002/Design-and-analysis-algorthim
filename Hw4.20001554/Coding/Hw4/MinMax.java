package Hw4;

import java.util.Random;

public class MinMax {
    public static int[] findMinMax(int[] arr, int start, int end) {
        if (end - start == 1)
            return new int[]{Math.min(arr[start], arr[end]), Math.max(arr[start], arr[end])};
        else if (start - end == 0) {
            return new int[]{arr[start], arr[start]};
        } else {
            int mid = (start + end) / 2;
            int[] leftResult = findMinMax(arr, start, mid);
            int[] rightResult = findMinMax(arr, mid + 1, end);
            return new int[]{Math.min(leftResult[0], rightResult[0]), Math.max(leftResult[1], rightResult[1])};
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        long startTime = System.currentTimeMillis();
        int start = 0;
        int end = arr.length - 1;
        for (int a :
                findMinMax(arr, start, end)) {
            System.out.println(a);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println();
        System.out.println("Thời gian chạy: " + totalTime + "ms");
    }
}
