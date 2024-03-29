
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int[] arr = new int[5];
        for(int i=0;i<5;i++){
            int n = Integer.parseInt(bf.readLine());
            sum+=n;
            arr[i]=n;
        }
        Arrays.sort(arr);
        bw.write(sum/5+"\n");
        bw.write(arr[2]+"\n");
        bw.close();
    }
}
