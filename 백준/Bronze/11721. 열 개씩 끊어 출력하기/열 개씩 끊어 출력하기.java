import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i!= 0 && i%10==0) {
                System.out.println(sb.toString());
                sb = new StringBuilder();
                sb.append(str.charAt(i));
            } else sb.append(str.charAt(i));
        }
        if(sb.length()>0) System.out.println(sb.toString());

    }
}
