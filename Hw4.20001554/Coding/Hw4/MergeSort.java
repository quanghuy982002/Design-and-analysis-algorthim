package Hw4;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 6, 1, 3, 9, 4, 8, 7 };
        System.out.println("Unsorted array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // Chia mảng thành 2 phần
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right); // Trộn 2 phần lại
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];

        int i = left; // Vị trí bắt đầu của phần tử trong mảng con trái
        int j = mid + 1; // Vị trí bắt đầu của phần tử trong mảng con phải
        int k = 0;

        // Trộn hai mảng con vào mảng tạm thời
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }

        // Trong trường hợp mảng con trái có các phần tử còn lại
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        // Trong trường hợp mảng con phải có các phần tử còn lại
        while (j <= right) {
            tempArr[k++] = arr[j++];
        }

        // Ghi đè mảng ban đầu với mảng đã trộn
        for (int x = 0; x < tempArr.length; x++) {
            arr[left + x] = tempArr[x];
        }
    }
}

