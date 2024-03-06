package chapter7;


public class test2 {
    int sum= 0;
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2); // --> 101, 10, 1
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        test2 T = new test2();
        T.DFS(11);
    }
}

