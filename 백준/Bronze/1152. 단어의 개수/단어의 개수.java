import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        
        if (s.isEmpty())
            System.out.print(0);
        else
            System.out.print(s.split(" ").length);
    }
}