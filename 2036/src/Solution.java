import java.util.Scanner;


public class Solution {
    public static boolean containsLetter(char[] letters, char c) {
        for (char letter : letters) {
            if (letter == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String s = scanner.nextLine();
        char[] glas = {'e', 'y', 'u', 'i', 'o', 'a'};
        for (int i = 0; i < count; i++) {
            s = scanner.nextLine();
            boolean no = false;
            for (int j = 0; j < s.length(); j++) {
                if (containsLetter(glas, s.charAt(j)) & containsLetter(glas, s.charAt(j + 1)) & containsLetter(glas, s.charAt(j + 3)))
                    no = true;
            }
            if (!no)
                System.out.println(s);
        }
    }
}
