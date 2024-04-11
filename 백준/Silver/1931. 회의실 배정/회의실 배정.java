
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class conferenceTime implements Comparable<conferenceTime>{
    int start;
    int end;

    public conferenceTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(conferenceTime o) {
        if(this.end==o.end) return this.start-o.start;
        return this.end-o.end; // 회의가 끝나는 시간을 기준으로 정렬
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<conferenceTime> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());
            pq.add(new conferenceTime(s,e));
        }
        int count = 1;
        int lastEndTime = pq.poll().end;
        while(!pq.isEmpty()){
            conferenceTime cf = pq.poll();
            if(lastEndTime<=cf.start){
                count++;
                lastEndTime = cf.end;
            }
        }
        bw.write(count+"\n");
        bw.close();
    }
}
