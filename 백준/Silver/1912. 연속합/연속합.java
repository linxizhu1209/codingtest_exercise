import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 18
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            max = Math.max(max,x);
        }

        for(int i=1;i<n;i++){
            int bx = arr[i-1];
            int x = arr[i];
            int sum = bx+x;
            if(sum>x) {
                arr[i] = sum;
                max = Math.max(max,sum);
            }
        }
        System.out.println(max);

    }
 }
