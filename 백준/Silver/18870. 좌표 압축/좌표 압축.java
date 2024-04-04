
import java.io.*;
import java.util.PriorityQueue;

class Position implements Comparable<Position>{
    int index;
    int pos;

    public Position(int index, int pos) {
        this.index = index;
        this.pos = pos;
    }

    @Override
    public int compareTo(Position o) {
        return this.pos-o.pos;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Position> pq = new PriorityQueue<>();
        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            pq.add(new Position(i,Integer.parseInt(str[i])));
        }
        int[] arr = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            Position p = pq.poll();
            arr[p.index] = count;
            if(pq.peek()!=null&&pq.peek().pos!=p.pos) count++;
        }
        for(int x:arr) bw.write(x+" ");
        bw.close();
    }
}
