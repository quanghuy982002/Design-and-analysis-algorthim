package ex3;

public class PrimeNumbers {
    public static boolean isPrime(int number, int divisor) {
        if (divisor == 1) {
            return true;
        } else {
            if (number % divisor == 0) {
                return false;
            } else {
                return isPrime(number, divisor - 1);
            }
        }
    }

    public static void printPrimes(int n, int current) {
        if (current <= n) {
            if (isPrime(current, current - 1)) {
                System.out.print(current + " ");
            }
            printPrimes(n, current + 1);
        }
    }

    public static void main(String[] args) {
        int n = 50;
        printPrimes(n, 2);
    }
}

