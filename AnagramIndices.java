import java.util.*;

public class AnagramIndices {
    public static List<Integer> findAnagramIndices(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return result;

        int[] pCharCount = new int[26]; // Assuming lowercase English alphabet characters
        for (char c : p.toCharArray())
            pCharCount[c - 'a']++;

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            // Decrease the count of current character in p
            if (pCharCount[s.charAt(right) - 'a'] >= 1)
                count--;

            pCharCount[s.charAt(right) - 'a']--;
            right++;

            // An anagram is found
            if (count == 0)
                result.add(left);

            // Move the sliding window
            if (right - left == p.length()) {
                // Increase the count of left character in p
                if (pCharCount[s.charAt(left) - 'a'] >= 0)
                    count++;

                pCharCount[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> indices = findAnagramIndices(s, p);
        System.out.println("Indices of p's anagrams in s: " + indices);
    }
}
