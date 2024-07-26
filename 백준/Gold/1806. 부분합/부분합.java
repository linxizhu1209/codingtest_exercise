
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

        int lt = 0;
        int rt = 0;
        long min = Long.MAX_VALUE;
        int sum = arr[lt];

        while(lt < n && rt<n){
            if((rt-lt)+1>=min){
                sum-=arr[lt];
                lt++;
                continue;
            }

            if(sum<m) {
                rt++;
                if(rt<n) sum+=arr[rt];
            }
            else{
                min = Math.min(min,(rt-lt)+1);
                sum-= arr[lt];
                lt++;
            }
        }

        if(min==Long.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
