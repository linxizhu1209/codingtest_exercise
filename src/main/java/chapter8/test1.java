package chapter8;

import java.util.Scanner;

public class test1 {

    static String answer = "NO";
    static int n = 0;
    static int total = 0;
    boolean flag = false;
    // 강의 참고 코드
    public void DFS(int L,int sum, int[] arr) {
        if(flag) return;
        if(sum>total/2) return;
        if(L==n){ // L이 배열의 마지막 숫자일때 끝
            if((total-sum)==sum){
                answer = "YES";
                flag=true;
            }
        }
        else{
            DFS(L+1,sum+arr[L],arr); //arr[L]을 포함한 경우
            DFS(L+1,sum,arr); // arr[L]을 포함하지 않은 경우
        }
    }


    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}

