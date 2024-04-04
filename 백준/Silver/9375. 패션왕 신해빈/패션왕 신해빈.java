import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            HashMap<String,Integer> map = new HashMap<>();
            int x = Integer.parseInt(br.readLine());
            StringTokenizer token;
            while(x!=0){
                token = new StringTokenizer(br.readLine());
                token.nextToken();
                String type = token.nextToken();
                map.put(type,map.getOrDefault(type,0)+1);
                x--;
            }
            int sum = 1;
            for (int o : map.values()) {
                    sum *= o+1;
            }

            bw.write((sum-1)+"\n");
        }
        bw.close();
    }
}
