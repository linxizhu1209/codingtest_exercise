
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                pq.offer(x);
            }
            else{
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else sb.append(pq.poll()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
