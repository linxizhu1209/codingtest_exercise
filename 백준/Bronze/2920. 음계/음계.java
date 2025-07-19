
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[9];
        for (int i = 1; i < 9; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean isAsc = false;
        boolean isDesc = false;
        if(arr[1]<arr[2]){
            isAsc = true;
        } else {
            isDesc = true;
        }

        if(isAsc){
            // 오름차순인 경우
            for(int i=1;i<9;i++){
                if(arr[i] != i){
                    isAsc = false;
                    break;
                }
            }
            System.out.println(isAsc?"ascending":"mixed");
        } else {
            for(int i=8;i>0;i--){
                if(arr[9-i] != i){
                    isDesc = false;
                    break;
                }
            }
            System.out.println(isDesc?"descending":"mixed");
        }
    }
}
