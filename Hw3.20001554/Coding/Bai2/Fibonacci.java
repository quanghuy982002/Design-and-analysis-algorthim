package hw4;

import java.util.Scanner;

public class Fibonacci {

    public static int findFibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            return findFibonacci(n - 1) + findFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giá trị cần tính: ");
        int n = sc.nextInt();
        System.out.println("Kết quả là: " + findFibonacci(n));
        long endTime = System.currentTimeMillis();
        long total = endTime - startTime;
        System.out.println("Thời gian chạy là: " + total + " ms.");

    }
}
