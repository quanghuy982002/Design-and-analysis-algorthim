package hw7.bai_2;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 6, 3, 8, 9, 7};
        int n = arr.length;

        // khởi tạo mảng tails với độ dài là n
        int[] tails = new int[n];
        int len = 1;
        tails[0] = arr[0];

        // tính giá trị của tails[i] bằng cách sử dụng Binary Search
        for (int i = 1; i < n; i++) {
            if (arr[i] < tails[0]) {
                tails[0] = arr[i];
            } else if (arr[i] > tails[len - 1]) {
                tails[len++] = arr[i];
            } else {
                tails[ceilIndex(tails, -1, len - 1, arr[i])] = arr[i];
            }
        }

        // in kết quả
        System.out.println("Dãy con tăng dài nhất có độ dài là: " + len);
    }

    // tìm chỉ số của phần tử đầu tiên trong mảng a lớn hơn giá trị x
    private static int ceilIndex(int[] a, int left, int right, int x) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
