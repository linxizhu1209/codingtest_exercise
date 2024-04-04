import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
                return Math.abs(o1)-Math.abs(o2);
            }
        });
        for(int i=0;i<n;i++){
           int x = Integer.parseInt(br.readLine());
            if(x==0&&!pq.isEmpty()) {
                bw.write(pq.poll()+"\n");;
            }
            else if(x==0&&pq.isEmpty()) bw.write(0+"\n");
            else pq.offer(x);
        }
        bw.close();
    }
}
