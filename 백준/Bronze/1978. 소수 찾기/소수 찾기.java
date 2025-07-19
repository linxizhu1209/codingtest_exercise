
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x<=1) continue;
            if(x==2) {
                count++;
                continue;
            }
            if(x%2==0){
                continue;
            } else if(x==3){
                count++;
            }else {
                // 홀수라면
                boolean isOk = true;
                for(int j=3;j<=Math.sqrt(x);j++){
                    if(x%j==0) { // 소수가 아니란 것
                        isOk = false;
                        break;
                    } 
                }
                if(isOk) count++;
            }
        }
        System.out.println(count);
    }
}
