
import java.io.*;
import java.util.*;

public class Main {
    /**

     */

    static class XY implements Comparable<XY> {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(XY o) {
            if(this.y==o.y) return this.x - o.x;
            return this.y-o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        PriorityQueue<XY> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new XY(x,y));
        }

        while (!pq.isEmpty()){
            XY xy = pq.poll();
            System.out.println(xy.x + " " + xy.y);
        }
    }

}