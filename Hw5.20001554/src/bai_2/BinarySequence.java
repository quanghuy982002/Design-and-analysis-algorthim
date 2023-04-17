// package Hw5.bai_2;

public class BinarySequence {

    public static void generateBinarySequence(int n) {
        boolean[] a = new boolean[n];
        generateBinarySequence(a, 0, n);
    }

    private static void generateBinarySequence(boolean[] a, int i, int n) {
        if (i == n) {
            for (boolean b : a) {
                System.out.print(b ? 1 : 0);
            }
            System.out.println();
        } else {
            for (int j = 0; j < 2; j++) {
                a[i] = (j == 1);
                generateBinarySequence(a, i + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateBinarySequence(n);
    }
}
