import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] numarr, check;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        numarr = new int[n];
        check = new int[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numarr[i] = Integer.parseInt(token.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = numarr[i] + numarr[j] + numarr[l];
                    if (sum <= m) {
                        max = Math.max(sum, max);
                    }
                }
            }
        }
        bw.write(max+"\n");
        bw.close();
    }
}
