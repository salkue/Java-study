import java.util.Scanner;

public class Solution {
    public static int findPairs(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (i != j && array[j] % array[i] == 0)
                    result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(findPairs(nums));
    }
}