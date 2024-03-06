package chapter7;


import java.util.Scanner;

public class test1 {
    // 강의 참고하여 짠 코드(선택정렬 활용)
    public void DFS(int n){
        if(n==0) return;
        else {
//            System.out.print(n+" ");
            DFS(n - 1);
            System.out.print(n+" ");
        }
        }

    public static void main(String[] args) {
        test1 T = new test1();
        T.DFS(3);
    }
}

