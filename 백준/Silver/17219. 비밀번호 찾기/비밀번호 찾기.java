import java.io.*;
import java.util.*;

public class Main {
    /**

     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(token.nextToken()); // 저장된 사이트-비밀번호 수
        int m = Integer.parseInt(token.nextToken()); // 찾으려는 비밀번호 수
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            token = new StringTokenizer(in.readLine());
            String site = token.nextToken();
            String pwd = token.nextToken();
            map.put(site, pwd);
        }
        for(int i=0; i<m; i++){
            String str = in.readLine();
            System.out.println(map.get(str));
        }
    }

}