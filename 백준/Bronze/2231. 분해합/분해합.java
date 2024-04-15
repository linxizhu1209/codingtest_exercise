
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numstr = String.valueOf(n);
        int firstNum = (numstr.charAt(0))-'0';
        int min = n-(numstr.length()*9);
        int max = n-firstNum;
        int answer = 0;
        if(numstr.length()==1){
            for(int i=1;i<n;i++){
                if(i+i==n) {
                    answer=i;
                    break;
                }
            }
        }
        else {
            for (int i = min; i <= max; i++) {
                int sum = i;
                int x = i;
                while (x >= 1) {
                    sum += x % 10;
                    x /= 10;
                }
                if (sum == n) {
                    answer = i;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
