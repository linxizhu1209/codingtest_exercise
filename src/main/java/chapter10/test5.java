package chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class test5 {
    // 강의 참고하여 내가 짠 코드
    static int n, m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;
        for(int i=0;i<n;i++){
            int x= coin[i];
            for(int j=x;j<=m;j++){
//                if(dy[j]>dy[j-coin[i]]+1) dy[j]=dy[j-coin[i]]+1;
            dy[j]=Math.min(dy[j],dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
        arr[i]=in.nextInt();
        }
        m=in.nextInt();
        dy=new int[m+1];
        System.out.println(T.solution(arr));
    }
}
