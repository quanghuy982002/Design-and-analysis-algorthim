package hw7.bai_3;

public class MaxSubarraySum {
    public static int maxSubarraySum(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+a[i], a[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 5, -2, 6, -1};
        int maxSum = maxSubarraySum(a);
        System.out.println("Max subarray sum: " + maxSum);
    }
}
