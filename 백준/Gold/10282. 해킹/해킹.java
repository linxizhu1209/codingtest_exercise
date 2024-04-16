import java.io.*;
import java.util.*;

class Infection implements Comparable<Infection>{
    int child;
    long infectTime;

    public Infection(int child, long infectTime) {
        this.child = child;
        this.infectTime = infectTime;
    }

    @Override
    public int compareTo(Infection o) {
        return (int) (this.infectTime-o.infectTime);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken()); // 컴퓨터의 개수
            int d = Integer.parseInt(token.nextToken()); // d만큼 for문 돌며 의존성 체크
            int c = Integer.parseInt(token.nextToken()); // 처음 감염된 컴퓨터
            ArrayList<ArrayList<Infection>> graph = new ArrayList<>();
            long[] infTime = new long[n+1];
            boolean[] ch = new boolean[n+1];
            for(int j=0;j<n+1;j++){
                graph.add(new ArrayList<>());
            }
            for(int j=0;j<d;j++){
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken()); // 자식 컴퓨터 (의존하는 컴퓨터)
                int b = Integer.parseInt(token.nextToken()); // 부모 컴퓨터 (의존되는 컴퓨터)
                int time = Integer.parseInt(token.nextToken()); // 감염에 걸리는 시간
                graph.get(b).add(new Infection(a,time));
            }
            PriorityQueue<Infection> pq = new PriorityQueue<>();
            pq.offer(new Infection(c,0));
            int count = 1; // 컴퓨터하나는 무조건 감염된 상태
            ch[c] = true;
            long totalTime = 0;
            while(!pq.isEmpty()){
                Infection ifec = pq.poll();
                for(Infection child:graph.get(ifec.child)){
                    long nextTime = child.infectTime+ ifec.infectTime;
                    if(ch[child.child]&&infTime[child.child]>nextTime) { // 다음 컴퓨터가 감염될때 걸린 시간이, 현재컴퓨터가 감염되는데 걸린 시간+다음컴퓨터가 감염되는데까지 걸리는 시간보다 크다면 더 빠른 시간내 감염될 수 있다는 것이므로 교체
                        infTime[child.child] = nextTime;
                        pq.offer(new Infection(child.child, nextTime));
                    }
                    else if(!ch[child.child]){
                        count++;
                        ch[child.child] = true;
                        infTime[child.child] = child.infectTime+ifec.infectTime;
                        pq.offer(new Infection(child.child, child.infectTime+ ifec.infectTime));
                    }
                }
            }
            totalTime = Arrays.stream(infTime).max().getAsLong();
            bw.write(count+" "+totalTime+"\n");
        }
        bw.close();
    }
}

