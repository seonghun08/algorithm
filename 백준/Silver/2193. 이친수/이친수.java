import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static int n;
	static long D[][] = new long[91][2];
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		D[1][0] = 0;
		D[1][1] = 1;
		
		for (int i = 2; i <= n; i++)
		{
			D[i][0] = D[i-1][0] + D[i-1][1];	// 0으로 시작
			D[i][1] = D[i-1][0];			// 1로 시작
		}
		
		System.out.println(D[n][0] + D[n][1]);
	}
}