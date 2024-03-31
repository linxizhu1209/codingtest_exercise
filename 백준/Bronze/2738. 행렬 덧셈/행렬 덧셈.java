import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int[][] arr1 = new int[n][m];
        for(int i=0;i<n;i++) {
            String[] num = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                arr1[i][j] = Integer.parseInt(num[j]);
            }
        }

        for(int i=0;i<n;i++){
            String[] num = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;j++) {
                sb.append(arr1[i][j] + Integer.parseInt(num[j]) + " ");
            }
            System.out.println(sb);
        }
    }
}
