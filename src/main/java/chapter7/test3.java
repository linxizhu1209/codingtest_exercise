package chapter7;


public class test3 {
  // 내가 짠 코드
    public int DFS(int n){
        if(n==0) return 1;
        else return DFS(n - 1)*n;
    }

    public static void main(String[] args) {
        test3 T = new test3();
        System.out.println(T.DFS(5));
    }
}

