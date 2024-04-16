
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. k개의 집중국을 세우기 위해서는 k-1개의 선으로 나눌 수 있다 => k개의 집중국 구역이 생성
 * 2. 각 구역을 합했을때 그 최소가 되는 값을 구하면 된다.
 * 3. 따라서, 센서마다의 거리를 배열로 만들어, 해당 배열에서 가장 긴 거리 순으로 k-1개를 제거하고, 남은 배열 숫자를 더한 값이 최소가 된다
 * 4. 간격이 긴 곳들을 구역을 나눌 구분선으로 정하면 그 간격이 총 거리에 포함되지 않을 것이므로,,, 최소가 된다
 * 5. 만약 집중국이 센서보다 많거나 같다면, 각 센서마다 집중국을 세우면 되므로 거리는 0이된다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];
        Integer[] dis = new Integer[n-1];
        if(n<=k) bw.write(0+"\n");
        else{
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                sensor[i] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(sensor); // 오름차순 정렬, 인접한 센서의 간격을 구하기 위함
            for(int i=1;i<n;i++){
                dis[i-1] = sensor[i]-sensor[i-1];
            }
            Arrays.sort(dis,(o1,o2)->o2-o1);
            int sum = 0;
            for(int i=k-1;i<n-1;i++){ // 가장 긴 간격순으로 나열한 배열에서 k-1번까지를 제외하고 그 다음부터 더해주면 최소 
                sum+=dis[i];
            }
            bw.write(sum+"\n");
        }
        bw.close();
    }
}
