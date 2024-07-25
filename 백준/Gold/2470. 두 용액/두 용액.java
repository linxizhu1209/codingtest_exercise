
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
            arr[i]= Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int lt=0;
        int rt=n-1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];


        while(lt<rt){
            int number = arr[lt]+arr[rt];
            if(Math.abs(number)<min){
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                min = Math.abs(arr[lt]+arr[rt]);
            }

            if(number<0) lt++;
            else if(number==0) break;
            else rt--;
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
