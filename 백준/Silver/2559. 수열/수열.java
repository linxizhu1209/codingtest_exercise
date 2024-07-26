
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
            if(i<m) sum+=arr[i];
        }
        int max = sum;
        for(int i=m;i<n;i++){
            sum+=arr[i];
            sum-=arr[i-m];
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}