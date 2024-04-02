
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


class paperNum{
    int n;
    int p;

    public paperNum(int n, int p) {
        this.n = n;
        this.p = p;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<paperNum> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            q.addLast(new paperNum(i, Integer.parseInt(arr[i - 1])));
        }
        while (!q.isEmpty()&&N!=0) {
            paperNum pn = q.pollFirst();
            bw.write(pn.n + " ");
            if(q.isEmpty()) break;
            if (pn.p > 0) {
                for (int i = 0; i < pn.p - 1; i++) {
                    paperNum b = q.pollFirst();
                    q.addLast(b);
                }
            } else {
                if(N+pn.p<=0){
                    int x = Math.abs(N+pn.p-1);
                    for(int i=0;i<x;i++){
                        q.addFirst(q.pollLast());;
                    }
                }
                else{
                for (int i = 0; i < (N + pn.p)-1; i++) {
                    q.addLast(q.pollFirst());
                }
            }}
            N--;
        }
        bw.close();
    }
}
