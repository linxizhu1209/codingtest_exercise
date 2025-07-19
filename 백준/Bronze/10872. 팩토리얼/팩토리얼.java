import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int fac = 1;
        if(n==0) System.out.println(1);
        else {
            for (int i=n;i>0;i--){
               fac *= i;
            }
            System.out.println(fac);
        }
    }
}
