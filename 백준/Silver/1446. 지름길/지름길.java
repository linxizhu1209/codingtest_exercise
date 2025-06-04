import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

    /**
     * 1. 출발지에서 도착지까지 지름길로 이동할 수 있는 최솟값
     * 2. n개의 줄에 시작위치 도착위치 길이가 주어짐
     * 3. 출발지-도착지를 그냥 가는 것과 지름길을 통해서 가는 것중. 더 최소인 것을 + 해줘야함.
     * 4. 우선순위 큐에넣어서, 출발지 기준으로 정렬, 도착지 기준으로 정렬, 거리 순으로 정렬한 다음에,
     */

    /**
     * 개선 방안
     * 1. 우선 list를 값으로 갖는 list를 생성. 해당 리스트는 1~ 10000개까지 존재 -> 해당 리스트는 시작지점을 기준으로, 해당 시작지점에서 갈 수 있는 도착점과 거리를 값으로 갖고있는 객체를 담은 리스트를 담고있음
     * 2. 크기가 10001인 배열을 만들고, 각 배열의 값에는 인덱스와 같은 값이 들어간다. 이는 각 위치까지의 거리를 재기위함
     * 3. 배열을 하나씩 돌면서, 현재 시작점보다 다음 위치 즉 +1 거리가 +1 거리보다 크다면, 최소값이 아니므로, 다음 위치의 값을 현재 위치의 값 + 1 해준다.
     * 4. 현재 시작점을 기준으로, 현재시작점 거리 + 다음도착지점까지의 지름길 거리가 다음도착지점까지의 원래거리(배열에들어있는거리) 보다 작다면, 다음도착지점까지의 원래거리에 지름길 거리를 할당
     * 5. 다음 시작지점을 기준으로 다시 메서드 호출
     */
    static class Road {
        int end;
        int length;

        Road(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }

    static int n;
    static int m;
    static List<List<Road>> roads = new ArrayList<>();
    static int[] distant = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken()); // 지름길의 개수
        m = Integer.parseInt(token.nextToken()); // 고속도로의 길이
        for(int i=0;i<10001;i++){
            roads.add(new ArrayList<>());
            distant[i] = i;
        }

        for(int i=0;i<n;i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int length = Integer.parseInt(token.nextToken());
            roads.get(start).add(new Road(end, length));
        }

        dijkstra(0);

        System.out.println(distant[m]);
    }

    public static void dijkstra(int start) {
        if(start>m) return;  // 이미 도착점보다 멀리와버렷기에 끝

        if(distant[start+1] > distant[start]+1){
            distant[start+1] = distant[start]+1;
        }

        for(int i=0;i<roads.get(start).size();i++){ // 도착지점까지의 지름길을 계산하여 거리를 갱신
            if(distant[start]+roads.get(start).get(i).length
                    < distant[roads.get(start).get(i).end]){
                distant[roads.get(start).get(i).end] = distant[start]+roads.get(start).get(i).length;
            }
        }

        dijkstra(start+1);
    }
}