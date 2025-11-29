package algorithms.chapter1.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.IO.println;

class LCS {

    public static String lcsBruteForce(String X, String Y) {
        List<String> subX = generateSubsequences(X);
        List<String> subY = generateSubsequences(Y);

        String best = "";

        Set<String> setY = new HashSet<>(subY);

        for (String a : subX) {
            if (a.length() <= best.length()) continue;
            if (setY.contains(a)) {
                best = a;
            }
        }

        return best;
    }

    public static List<String> generateSubsequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        int total = 1 << n; // 2^n

        for (int mask = 0; mask < total; mask++) {
            StringBuilder subseq = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subseq.append(s.charAt(i));
                }
            }
            result.add(subseq.toString());
        }
        return result;
    }

    void main() {
        String a = "1, 2, 3, 4, 5, 6";
        String b = "2, 3, 5, 5, 6, 9";
        println(lcsBruteForce(a, b));
    }

}
