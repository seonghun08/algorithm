import java.util.Scanner;

public class Main {

    private static final int SIZE = 100;

    public static void main(String[] args) {
        boolean[][] arr = new boolean[SIZE][SIZE];
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        answer++;
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
