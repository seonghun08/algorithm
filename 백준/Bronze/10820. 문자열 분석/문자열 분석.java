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
                int[] counts = line.chars()
                        .map(ch -> {
                            if (Character.isLowerCase(ch)) return 0;
                            if (Character.isUpperCase(ch)) return 1;
                            if (Character.isDigit(ch)) return 2;
                            return 3;
                        })
                        // Supplier: 결과를 담을 "빈 그릇"을 준비
                        // Accumulator: 스트림의 각 데이터를 "빈 그릇"에 추가
                        // Combiner: 병렬 스트림 처리 시, 여러 "빈 그릇"을 하나로 합침
                        .collect(
                                () -> new int[4],
                                (arr, idx) -> arr[idx]++,
                                (arr1, arr2) -> {
                                    for (int i = 0; i < 4; i++) arr1[i] += arr2[i];
                                });
                for (int a : counts) {
                    bw.write(a + " ");
                }
                bw.write("\n");
            }
            bw.flush();
        }
    }
}
