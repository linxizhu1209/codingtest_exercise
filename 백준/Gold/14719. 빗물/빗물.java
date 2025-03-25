
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /**
         * max 하나 받아놓고,
         * 처음 lt, 그다음 rt, lt보다 rt가 작으면 sum += lt-rt, rt++
         * lt보다 rt가 크거나 같으면 그 순간 lt = rt가 되면서 +는 없음
         * 다시 rt ++, lt<rt면 0이고 함께 움직임 즉 lt++, rt++
         * 다만 max와 rt가 같아지는 순간, 끝에서부터 lt,rt 시작하고, lt < rt이면 sum += rt-lt, lt--, lt가 max만나는 순간 끝
         */

        Scanner in = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(in.nextLine());
        int h = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(in.nextLine());
        int[] arr = new int[w];
        for(int i=0; i<w; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        };
        int sum = 0;
        for(int i=1; i<w-1;i++){ // 현재 값 arr[i]
            int left = 0; int right = 0;
            for(int n=0; n<i; n++){
                left = Math.max(left, arr[n]);
            }
            
            for(int m=i+1; m<w; m++){
                right = Math.max(right, arr[m]);
            }
            
            if(arr[i] < left && arr[i] < right){
                sum += Math.min(left,right) - arr[i]; 
            }
        }
        System.out.println(sum);
    }
}