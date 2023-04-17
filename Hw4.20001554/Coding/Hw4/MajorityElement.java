package Hw4;

import java.util.Arrays;
import java.util.Random;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        Arrays.sort(arr);
        int n = arr.length;
        long startTime = System.currentTimeMillis();
        int majorityElement = getMajorityElement(arr, 0, n - 1);
        if (majorityElement != -1) {
            System.out.println("The majority element is " + majorityElement);
        } else {
            System.out.println("There is no majority element in the array.");
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println();
        System.out.println("Thời gian chạy: " + totalTime + "ms");
    }

    public static int getMajorityElement(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        int left = getMajorityElement(arr, low, mid);
        int right = getMajorityElement(arr, mid + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = countOccurrences(arr, low, mid, left);
        int rightCount = countOccurrences(arr, mid + 1, high, right);
        return (leftCount > rightCount) ? left : right;
    }

    public static int countOccurrences(int[] arr, int low, int high, int num) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }
}