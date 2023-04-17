// package Hw5.bai_2;

import java.util.ArrayList;
import java.util.List;

public class BruteForceStringMatching {

    public static List<Integer> bruteForceStringMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String text = "ABAAABCDBBABCDDEBCABC";
        String pattern = "ABC";

        List<Integer> res = bruteForceStringMatching(text, pattern);

        System.out.println("Các vị trí xuất hiện của xâu mẫu '" + pattern + "' trong văn bản '" + text + "':");
        for (int i : res) {
            System.out.println(i);
        }
    }
}
