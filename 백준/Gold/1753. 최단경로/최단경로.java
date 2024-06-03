
import java.io.*;
import java.util.*;

class Route implements Comparable<Route>{
    int x;
    int num;

    public Route(int x, int num) {
        this.x = x;
        this.num = num;
    }
    @Override
    public int compareTo(Route o) {
        return this.num-o.num;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);
        int start = Integer.parseInt(br.readLine());
        int[] dis = new int[v+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        ArrayList<ArrayList<Route>> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int distance = Integer.parseInt(token.nextToken());
            graph.get(x).add(new Route(y,distance));
        }
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for(Route r:graph.get(start)){
            pq.offer(r);
        }
        dis[start] = 0;
        while(!pq.isEmpty()){
            Route route = pq.poll(); // 뽑은 노드를 항상 사용하면 안된다.
            int next = route.x;
            int distance = route.num;
            if(distance>dis[next]) continue;
            dis[next] = distance;
            for (Route r : graph.get(next)) {
                if(dis[r.x]>r.num+distance) {
                    pq.offer(new Route(r.x, r.num + distance));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=v;i++){
            if(i!=start&&dis[i]==Integer.MAX_VALUE){
                sb.append("INF"+"\n");
            }
            else sb.append(dis[i]+"\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
