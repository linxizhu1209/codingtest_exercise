
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        long k = Long.parseLong(token.nextToken());
        long n = Long.parseLong(token.nextToken());
        long maxLength = Long.MIN_VALUE;
        long[] arr = new long[(int) k];
        for(int i=0;i<k;i++){
            long m = Long.parseLong(br.readLine());
            arr[i] = m;
            maxLength = Math.max(maxLength,m);
        }

        long start = 1;
        long end = maxLength+1;

        while(start<end){
            long mid = (start+end)/2;
            long sum = 0;
            for(int i=0;i<k;i++){
                long x = arr[i];
                sum += x/mid;
            }
            if(sum>=n) start = mid+1;
            else end = mid;
        }
        System.out.println(start-1);
    }
}
