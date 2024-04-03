
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Order{
    int order;
    int impo;

    public Order(int order, int impo) {
        this.order = order;
        this.impo = impo;
    }
}
public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        Main p = new Main();
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            bw.write(p.solution(T) + "\n");
        }
        bw.close();
        }
    public int solution(int T) throws IOException {
        Queue<Order> q = new LinkedList<>();
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]); // 들어올 숫자 개수
            int t = Integer.parseInt(str[1]); // 찾고싶은 숫자의 현재 위치
            String[] numarr = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                q.offer(new Order(j,Integer.parseInt(numarr[j])));
            }
            int count = 0;
            while(!q.isEmpty()){
                Order tmp = q.poll();
                for(Order o:q) {
                    if (tmp.impo < o.impo) {
                        q.offer(tmp);
                        tmp = null;
                        break;
                    }
                }
                if(tmp!=null){
                    count++;
                    if(tmp.order==t) {
                        return count;
                    }
                }
        }
        return 0;
    }
}
