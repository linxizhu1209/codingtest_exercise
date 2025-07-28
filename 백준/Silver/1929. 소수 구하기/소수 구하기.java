
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // m이상 n이하의 소수

        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for(int i=2;i*i<=n;i++){
            if(arr[i]){ // 이미 소수가 아닌걸로 판별됐다면, 그의 배수도 소수가 아니므로 굳이 돌 필요없음
                for(int j=i*i;j<=n; j += i){ // i*i부터 하는 이유는 그 전의 것들은 이미 이전 for문에서 걸러졌을 것이기때문
                    arr[j] = false;
                }
            }
        }
        for(int i=m;i<=n;i++){
            if(arr[i]){
                System.out.println(i);
            }
        }
    }

 }
