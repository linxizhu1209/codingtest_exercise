import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] arr;
    static int n;
    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        int max = 0;
        /**
         * 1. 시작 날짜가 같다면 더 긴 일정을 위로, 즉 끝나는 end 날짜가 더 큰 게 우선순위
         * 2. 시작 날짜가 같지않다면, 더 일찍시작하는 일정을 위로, 즉 시작하는 start 날짜가 더 빠른 게 우선순위
         */
        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> {
                if(e1.start == e2.start){
                return e2.end - e1.end;
                }
                return e1.start - e2.start;
        });

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Pair(start, end));
            // max 체크의 이유는 365일까지 보기엔 넘 많으므로, 일정중 가장 마지막 날짜까지만 배열만들어서 체크하려고
            max = Math.max(max,end);
        }
        arr = new int[n][max+2];

        while (!pq.isEmpty()){
            Pair pair = pq.poll();
            for(int i = 0; i < n; i++){
                if(arr[i][pair.start]==1){
                    continue; // continue를 하는 이유는, 해당 점이 1이라는 이유는 거기에 이미 일정이 있다는 것이기 때문에 다음 줄로 넘어감
                }
                // 만약 위에 안걸렸다면, 연속으로 열 체크하면 된다
                for(int j=pair.start;j<=pair.end;j++){
                    arr[i][j] = 1;
                }
                break; // break를 해야하는 이유는 이미 pair 숫자는 모두 체크했기때문
            }
        }

        int sum = 0;
        // 이제 wideMax와 wideMin을 파악하고, height를 파악
        int wideMax = 0;
        int wideMin = 365;
        int height = 0;
        for(int j=0;j<arr[0].length;j++){

            boolean stop = true;
            for(int i=0;i<n;i++){
                if(arr[i][j]==1){
                    wideMax = Math.max(wideMax,j);
                    wideMin = Math.min(wideMin,j);
                    height = Math.max(height,i+1);
                    stop = false;
                }
            }
            if(stop){
                sum += ((wideMax-wideMin)+1)*height;
                wideMax = 0;
                wideMin = 365;
                height = 0;
            }
        }
        System.out.println(sum);
    }
}