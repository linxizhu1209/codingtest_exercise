import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 1; // dp[1]
        int b = 2; // dp[2]
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = (a + b) % 10;
            a = b;
            b = c;
        }

        System.out.println(n == 2 ? b : b);
    }
}