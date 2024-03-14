package chapter8;

import java.util.Scanner;

public class test6 {
    /**
     * 강의 참고한 코드
     */
    static int n,m = 0;
    static int[] pm, ch;
    public void DFS(int L,int[] arr, int bn) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
//                if(ch[i]==0){
//                    ch[i]=1;
//                    pm[L]=arr[i];
//                    DFS(L+1);
//                    ch[i]=0;
//                }  ---> ch배열(체크배열)에 해당 숫자를 이미 pm배열에 넣었는지 체크하면서 하는 방법도있음
                if(bn==arr[i]) {}
                else{
                    pm[L] = arr[i];
                    DFS(L + 1, arr,arr[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        test6 T = new test6();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        m= in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        T.DFS(0,arr,0);
        }
}

