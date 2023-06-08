import java.util.*;
public class StringCompression {

    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];

                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(chars);
        System.out.print("Return " + newLength + ", and the first " + newLength + " characters of the input array should be: [");
        for (int i = 0; i < newLength; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("\"" + chars[i] + "\"");
        }
        System.out.println("]");
    }
}
