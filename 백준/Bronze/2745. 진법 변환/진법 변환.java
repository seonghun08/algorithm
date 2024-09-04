import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        int b = sc.nextInt();

        int answer = 0;
        int tmp = 1;
        
        for (int i = n.length - 1; i >= 0; i--) {
            if ('A' <= n[i] && n[i] <= 'Z') {
                answer += (n[i] - ('A' - 10)) * tmp;
            } else {
                answer += (n[i] - '0') * tmp;
            }
            tmp *= b;
        }
        
        System.out.print(answer);
    }
}
