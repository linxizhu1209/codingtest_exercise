import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n]; // 감소하는 부분 길이를 체크하기 위한 배열
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        answer = Integer.MIN_VALUE;
        Main t = new Main();
        dy[0] = 1; // 각각의 원소는 무조건 길이 1은 충족하고, 첫번째 원소는 언제나 길이가 1이기때문에 미리 넣어둔다
        bw.write(t.solution(arr,dy)+"\n");
        bw.close();
    }
    private int solution(int[] arr, int[] dy){
        if(n==1) return 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]&&dy[j]>max){
                    max = dy[j]; // 만약 내 앞에 숫자가 나보다 크고, 그 연속된 길이가 현재 max보다 크다면, 그 연속된 길이(dy[j])를 max에 할당
                    // => max에 할당하는 이유는, for문으로 더 앞에 숫자들을 탐색하면서 나보다 큰 숫자가 있나 찾을 건데, 그때 찾은 숫자의 길이보다 현재의 max가 크다면
                    // 연속된 길이가 가장 긴 것에 더해나가는게 가장 긴 수열을 만드는 방법이므로 ...... (?)
                }
            }
            dy[i] = max+1; // 만약 for문을 돌면서 나보다 큰 숫자가 없었더라면, max(0) +1 이므로 dy[i]의 값은 1이된다. 즉, 부분수열의 길이가 1
            answer = Math.max(dy[i],answer); // 가장 긴 수열을 찾는 것이므로 dy배열중 가장 긴 길이를 answer에 계속 업데이트
        }
        return answer;
    }
}
