
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }
        Arrays.sort(arr); // 오름차순 정렬
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }
        boolean finish = false;
        Collections.sort(sum); // 오름차순 정렬
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minusNum = arr[i] - arr[j];
                if (Collections.binarySearch(sum, minusNum) >= 0) {
                    bw.write(arr[i]+"\n");
                    finish = true;
                    break;
                }
            }
            if(finish) break;
        }
        bw.close();
    }
}
