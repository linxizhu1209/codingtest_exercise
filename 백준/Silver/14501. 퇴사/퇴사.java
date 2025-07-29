
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    static String[][] arr;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[2][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[0][i] = a;
            arr[1][i] = b;
        }

        counsel(0,0);
        System.out.println(max);
    }
    private static void counsel(int day, int sum){
        if (day >= n) {
            max = Math.max(max, sum);
            return;
        }

        // 1. 상담을 한다면
        if (day + arr[0][day] <= n) {
            counsel(day + arr[0][day], sum + arr[1][day]);
        }

        // 2. 상담을 하지 않고 그냥 넘어간다
        counsel(day + 1, sum);
    }
 }
