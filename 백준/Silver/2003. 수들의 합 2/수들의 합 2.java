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
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int count = 0;
        int lt = 0;
        int rt = 0;

        while (rt<n){
            int sum = 0;
            for(int i=lt;i<=rt;i++) sum+=arr[i];
            if(rt==lt){
                if(arr[rt]==m) count++;
                rt++;
                continue;
            }

            if(sum<m) rt++;
            else if(sum>m) lt++;
            else{
                count++;
                rt++;
            }
        }
        System.out.println(count);
    }
}
