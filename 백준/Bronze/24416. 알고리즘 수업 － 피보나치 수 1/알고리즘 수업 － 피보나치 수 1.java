import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static int[] arr;
    static int count1;
    static int count2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[41];
        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    static private int fib(int n){ // 시간제한없을때 재귀
        if(n == 1 || n == 2){
            count1++;
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    static private int fibonacci(int n){ // 시간제한 있을때 배열로 저장
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
            count2++;
        }
        return arr[n];
    }
}
