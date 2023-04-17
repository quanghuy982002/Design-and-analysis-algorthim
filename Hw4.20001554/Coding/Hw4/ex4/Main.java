package Hw4.ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of equations: ");
        int n = input.nextInt();
        double[][] A = new double[n][n + 1];
        System.out.println("Enter the coefficients of the equations:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                A[i][j] = input.nextDouble();
            }
        }
        double[] x = divideAndConquer(A);
        System.out.println("The solution is:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.2f\n", i + 1, x[i]);
        }
    }

    public static double[] divideAndConquer(double[][] A) {
        int n = A.length;
        if (n == 1) {
            double[] x = new double[1];
            x[0] = A[0][n] / A[0][0];
            return x;
        }
        double[][] L = new double[n / 2][n / 2 + 1];
        double[][] U = new double[n / 2][n / 2 + 1];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2 + 1; j++) {
                L[i][j] = A[i][j];
                U[i][j] = A[i + n / 2][j];
            }
        }
        double[] y1 = divideAndConquer(L);
        double[] y2 = divideAndConquer(U);
        double[] y = new double[n];
        for (int i = 0; i < n / 2; i++) {
            y[i] = y1[i];
            y[i + n / 2] = y2[i];
        }
        return y;
    }
}
