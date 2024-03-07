package chapter7;

public class test4 {
    static int[] fibo;
  // 강의 참고 코드
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n]; // 재귀를 뻗을 필요없이 저장된 값으로 바로 가져올수있다. memorization!
        if(n==1) return fibo[n]= 1;
        else if(n==2) return fibo[n] = 1;
        else{
            return fibo[n] = DFS(n-2)+DFS(n-1);
        }
    }

    public static void main(String[] args) {
        test4 T = new test4();
        int n=10;
        fibo=new int[n+1];
        T.DFS(n);
        for(int i=1;i<=n;i++){
        System.out.println(fibo[i] + " ");
//        System.out.println(T.DFS(i));
        }
    }
}

