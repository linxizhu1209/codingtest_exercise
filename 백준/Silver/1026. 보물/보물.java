import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum+= a[i]*b[i];
        }
        System.out.println(sum);
    }

 }
