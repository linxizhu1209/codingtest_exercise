import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int x;
    static int[] check;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m  =Integer.parseInt(str[1]);
        check = new int[100001]; // 100001로 방문여부 배열을 만든 이유는 수빈이와 동생의 위치가 0부터 100,000까지 범위이기때문이다.
        Main t = new Main();
        int answer;
        if(n==m) answer = 0;
        else answer = t.BFS(n,m);
        bw.write(answer+"\n");
        bw.close();
    }
    public int BFS(int n, int m){
        int L = 0;
        q = new LinkedList<>();
        q.offer(n);
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                x = q.poll();
                if(x+1==m) return L+1;
                else check(x+1);
                if(x-1==m) return L+1;
                else check(x-1);
                if(x*2==m) return L+1;
                else check(x*2);
            }
            L++;
        }
        return 0;
    }

    public void check(int nx){ // 이동한 다음 숫자
        if(nx>=1&&nx<=100000&&check[nx]==0){
            check[nx]=1;
            q.offer(nx);
        }
    }
}
