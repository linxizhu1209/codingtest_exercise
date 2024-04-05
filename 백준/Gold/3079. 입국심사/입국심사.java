import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 심사대 수
        int m = Integer.parseInt(str[1]); // 사람 수
        long min = 1;
        long max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            arr[i]  = x;
            max = Math.max(max,x);
        }
        max = max*m; // 가장 오래걸리는 카운터에서 m명 모두를 처리했을 경우 걸리는 시간
        long sum = 0;

        while(min<max){
            long mid = (max+min)/2;
            sum = 0;
            for(int i=0;i<n;i++){
                sum += mid/arr[i];
                if(sum>m) break;
            }
            if(sum>=m){
                max = mid;
            }
            else {
                min = mid+1;
            }
        }
        bw.write(max+"\n");
        bw.close();

    }
}
