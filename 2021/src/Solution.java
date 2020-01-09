import java.util.Scanner;

public class Solution {
    public static int findMax(int[] array) {
        int max = array[1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int j = 0; j < 2; j++) {
            int max = findMax(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max)
                    nums[i] = (int) Math.floor(nums[i] / 2);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}