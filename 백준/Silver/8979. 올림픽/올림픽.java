
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static class Nation implements Comparable<Nation> {
        int nationNum;
        int g;
        int s;
        int b;

        public Nation(int nationNum,int g, int s, int b) {
            this.nationNum = nationNum;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Nation o) {
            if(this.g != o.g) return o.g - this.g; // 금메달 내림차순
            if(this.s != o.s) return o.s - this.s; // 은메달 내림차순
            return o.b - this.b; // 동메달 내림차순
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(in.nextLine());
        int nation = Integer.parseInt(token.nextToken()); // 국가 수
        int wantNation = Integer.parseInt(token.nextToken()); // 알고싶은 국가의 번호
        // map으로 ? 우선순위큐?
        PriorityQueue<Nation> pq = new PriorityQueue<>();
        int count = 1; // 등수
        for(int i=0;i<nation;i++) {
            token = new StringTokenizer(in.nextLine());
            int n = Integer.parseInt(token.nextToken()); // 국가 숫자
            int g = Integer.parseInt(token.nextToken()); // 금
            int s = Integer.parseInt(token.nextToken()); // 은
            int b = Integer.parseInt(token.nextToken()); // 동
            Nation nt = new Nation(n,g,s,b);
            pq.add(nt);
        }

        while(!pq.isEmpty()) {
            Nation n = pq.poll();
            if(n.nationNum == wantNation) {
                System.out.println(count);
                break;
            }
            count++;
        }
    }
}