import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        for(int i=0;i<9;i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                int n = Integer.parseInt(arr[j]);
                if(n>max) {
                    max=n;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((x+1)+" "+(y+1));
    }
}
