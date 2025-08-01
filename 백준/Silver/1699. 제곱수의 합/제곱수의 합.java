
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1;i<=n;i++) {
            arr[i] = i; // 1의 제곱수, 즉 1이 i번 들어가는게 최대값이므로
            for(int j=1;j*j<=i;j++){
                arr[i] = Math.min(arr[i], arr[i-j*j]+1); // 여기서 +1 을 해주는 이유는, j*j 를 쓰는 경우!를 넣은 것이니까 이 경우를 +1 해주는 것
            }
        }
        System.out.println(arr[n]);
    }
}