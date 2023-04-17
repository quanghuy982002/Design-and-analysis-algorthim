package ex3;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        int number = 1234;
        int sum = sumOfDigits(number);
        System.out.println("Tổng các chữ số của " + number + " là: " + sum);
    }
}
