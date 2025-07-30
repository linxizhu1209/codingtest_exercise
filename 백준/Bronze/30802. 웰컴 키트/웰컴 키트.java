import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[6];

        for(int i=0;i<6;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(token.nextToken()); // 티셔츠 수
        int p = Integer.parseInt(token.nextToken()); // 펜의 묶음 수
        int sum = 0;
        for(int i=0;i<6;i++){
            if(arr[i]%t == 0){
                sum+=arr[i]/t;
            } else {
                sum+=(arr[i]/t) + 1;
            }
        }
        System.out.println(sum);
        System.out.println(n/p+" "+n%p);
    }
 }
