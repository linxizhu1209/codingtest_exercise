
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            sum += a;
        }
        int[] charr = new int[9];
        Arrays.sort(arr);
        Arrays.fill(charr,1);
        int count = 0;
        boolean isFinish = false;
        // 7 8 10 13 15 19 20 23 25
        for(int i=0;i<9;i++){
            for(int j=i;j<9;j++){
                int sum2 = sum;
                sum2 -= arr[i] + arr[j];
                if(sum2 == 100){
                    charr[i] = 0;
                    charr[j] = 0;
                    isFinish = true;
                    break;
                }
            }
            if(isFinish){
                break;
            }
        }

        for(int i=0;i<9;i++){
            if(charr[i] == 1){
                System.out.println(arr[i]);
            }
        }

    }
}