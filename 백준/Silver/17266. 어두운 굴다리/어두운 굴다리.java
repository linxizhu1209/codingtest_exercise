import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1. 가로등 설치할 개수 M, 각 가로등의 위치 x
     * 2. 가로등의 높이 = 비출 수 있는 거리 (ex, 높이가 5라면 가로 5 세로 5 비추기 가능)
     * 3. 가로등의 높이를 최소로! 인데 모든 가로등의 높이가 같아야함
     * 4. 길이가 주어질때 해당 크기의 배열을 만들고 밝아짐 1, 밝지않음 0 으로 채워넣기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 굴다리 길이
        int m = Integer.parseInt(br.readLine()); // 가로등 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] marr = new int[m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(min, x);
            max = Math.max(max, x);
            marr[i] = x;
        }
        // 최소길이는 첫 가로등 위치와 마지막 가로등 위치가 길의 끝을 커버해야함
        int minLength = 1;
        // min과 최대길이 n 을 갖고 이분탐색
        int[] narr = new int[n+1]; // 거리 밝기 현황
        // 배열을 어떻게 돌아야하지. ==> 최소길이부터 n까지 for문 돌며
        int maxLength = n;
        int mid = 0;
        int answer = 0;
        while(minLength<=maxLength){
            narr = new int[n];
            mid = (minLength+maxLength)/2;
            boolean possible = true;
            if(marr[0]-mid>0){
                possible = false;
            }

            if(marr[marr.length-1]+mid<n) possible = false;

            for(int i=0;i<m-1;i++){
                if(marr[i+1]-marr[i] > 2*mid){
                    possible = false;
                    break;
                }
            }

            if(possible){
                answer = mid;
                maxLength = mid-1;
            } else minLength = mid+1;
        }


        System.out.println(answer);
    }
}
