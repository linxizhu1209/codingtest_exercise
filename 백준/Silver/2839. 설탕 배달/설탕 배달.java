import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int s = 5000/3;
        Arrays.fill(arr,s);
        // n을 3과 5의 최소 조합으로 만들기
        for(int i=3;i<=n;i++) {
            // i 를 만들때, 3을 j개 가져갔을때 5로 나눠떨어지는지 확인 (j+ 나머지/5)
            for(int j=0;j<=i;j++){
                int x = i; // 4
                x -= 3*j;
                if(x==0) {
                    arr[i] = Math.min(arr[i],j);
                    continue;
                }
                if(x<0) break;
                if(x%5==0){
                    arr[i] = Math.min(arr[i],(x/5 + j));
//                    arr[i] = x/5 + j;
                }
            }
        }
        if(arr[n]==s) System.out.println(-1);
        else System.out.println(arr[n]);
    }
}