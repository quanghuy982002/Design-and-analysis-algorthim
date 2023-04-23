package Hw6;

import java.util.Random;

public class CoinChange {
    public static int[] getMinCoins(int[] denominations, int amount) {
        int n = denominations.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = 0;
        }

        int i = 0;
        while (i < n && amount > 0) {
            result[i] = amount / denominations[i];
            amount = amount - result[i] * denominations[i];
            i++;
        }

        if (amount > 0) {
            // No solution
            return null;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10000; // Kích thước của mảng ngẫu nhiên
        int maxVal = 100; // Giá trị tối đa của phần tử trong mảng
        int amount = 1234; // Giá trị cần tìm số lượng đồng xu tối thiểu

        int[] denominations = new int[n];
        Random random = new Random();

        // Tạo mảng ngẫu nhiên
        for (int i = 0; i < n; i++) {
            denominations[i] = random.nextInt(maxVal) + 1;
        }

        long startTime = System.nanoTime();
        int[] minCoins = getMinCoins(denominations, amount);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        if (minCoins == null) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Minimum number of coins needed:");
            for (int i = 0; i < minCoins.length; i++) {
                System.out.println(denominations[i] + " cents: " + minCoins[i]);
            }
        }

        System.out.println("Execution time: " + duration + " nanoseconds.");
    }
}
