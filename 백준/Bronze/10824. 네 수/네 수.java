import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        long a = Long.parseLong(line[0] + line[1]);
        long b = Long.parseLong(line[2] + line[3]);
        System.out.println(a + b);
    }
}
