
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        int[] dy = new int[n];
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int answer = 0;
        dy[0]=1;
        for(int i=1;i<n;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(x>arr[j][0]&&y>arr[j][1]) {
                    max = Math.max(dy[j],max);
                }
            }
            dy[i] = max+1;
            answer = Math.max(dy[i],answer);
        }
        bw.write(n-answer+"\n");
        bw.close();
    }
}
