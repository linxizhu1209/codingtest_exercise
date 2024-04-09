import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            int bl = Arrays.binarySearch(arr,Integer.parseInt(str2[i]));
            if(bl>=0) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        bw.close();
    }
}
