
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] dis = new int[n-1];
        int[] oilCost = new int[n];
        int[] min = new int[n];
        for(int i=0;i<n-1;i++){
            dis[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(token.nextToken());
            oilCost[i] = x;
            if(i==0) min[i]= x;
            else min[i] = Math.min(min[i-1],x); //
        }
        int sum = 0;
        sum = dis[0]*oilCost[0]; // 도시 하나는 무조건 기름을 넣고 가야하므로 그 거리만큼은 넣어야함
        for(int i=1;i<n-1;i++){
            sum+=dis[i]*min[i];
        }
        bw.write(sum+"\n");
        bw.close();
    }
}
