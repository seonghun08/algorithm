import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(in.nextLine());
         int[] nums = Arrays.stream(
                        String.valueOf(sb.reverse()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print(Math.max(nums[0], nums[1]));
    }
}