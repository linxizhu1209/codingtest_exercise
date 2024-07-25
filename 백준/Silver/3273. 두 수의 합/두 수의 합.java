import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        int count = 0;
        while(lt<rt){
            if(arr[lt]+arr[rt]==x) {
                count++;
                rt--;
                lt++;
            }
            else if(arr[lt]+arr[rt]<x) lt++;
            else rt--;
        }
        System.out.println(count);
    }
}
