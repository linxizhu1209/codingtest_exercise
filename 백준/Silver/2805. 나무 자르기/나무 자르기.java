import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        String[] tree = br.readLine().split(" ");
        long max = Integer.MIN_VALUE;
        long min = 0;
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(tree[i]);
            arr[i] = x;
            max = Math.max(x, max);
        }
        while (min < max) {
            long middleNum = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > middleNum) {
                    sum += arr[i] - middleNum;
                }
            }
            if (sum >= m) {
                min = middleNum+1;
            } else if (sum < m) {
                max = middleNum;
            }
        }
    bw.write(min-1+"\n");
    bw.close();
    }
}