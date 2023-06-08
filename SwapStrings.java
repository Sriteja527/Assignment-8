import java.util.*;
public class SwapStrings {
    public static boolean canSwapStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    return false; // More than two mismatches
                }
            }
        }

        if (firstMismatch == -1 && secondMismatch == -1)
            return false; // No mismatches

        return s.charAt(firstMismatch) == goal.charAt(secondMismatch) &&
                s.charAt(secondMismatch) == goal.charAt(firstMismatch);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String goal = sc.nextLine();
        boolean canSwap = canSwapStrings(s, goal);
        System.out.println("Can swap strings? " + canSwap);
    }
}
