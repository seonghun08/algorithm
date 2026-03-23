import java.util.Scanner;

public class Main0905 {

    static int[] unf;

    public static int find(int x) {
        if (unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(find(a) == find(b) ? "YES" : "NO");
    }
}
