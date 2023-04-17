// package Hw5.bai_3;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    private static int[] arr;
    private static int S;
    private static int bestSum = -1;
    private static List<Integer> bestSubset = new ArrayList<>();

    public static List<Integer> subsetSum(int[] arr, int S) {
        SubsetSum.arr = arr;
        SubsetSum.S = S;

        dfs(0, 0, new ArrayList<>());

        return bestSum == S ? bestSubset : null;
    }

    private static void dfs(int i, int currSum, List<Integer> currSubset) {
        if (currSum == S) {
            bestSum = S;
            bestSubset = new ArrayList<>(currSubset);
            return;
        }

        if (currSum > S || i == arr.length) {
            return;
        }

        // Branch by adding or not adding the i-th element
        currSubset.add(arr[i]);
        dfs(i + 1, currSum + arr[i], currSubset);
        currSubset.remove(currSubset.size() - 1);
        dfs(i + 1, currSum, currSubset);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 8, 1};
        int S = 9;

        List<Integer> subset = subsetSum(arr, S);

        if (subset == null) {
            System.out.println("No subset found with sum = " + S);
        } else {
            System.out.println("Subset with sum = " + S + ": " + subset);
        }
    }
}
