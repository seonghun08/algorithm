import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line;
            while ((line = br.readLine()) != null) {
                int[] arr = new int[4];
                for (char ch : line.toCharArray()) {
                    if (Character.isLowerCase(ch)) {
                        arr[0]++;
                    } else if (Character.isUpperCase(ch)) {
                        arr[1]++;
                    } else if (Character.isDigit(ch)) {
                        arr[2]++;
                    } else {
                        arr[3]++;
                    }
                }
                for (int a : arr) {
                    bw.write(a + " ");
                }
                bw.write("\n");
            }
            bw.flush();
        }
    }
}
