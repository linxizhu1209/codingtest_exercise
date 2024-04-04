import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            HashMap<String,Integer> map = new HashMap<>();
            int x = Integer.parseInt(br.readLine());
            for(int j=0;j<x;j++){
                String[] str = br.readLine().split(" ");
                map.put(str[1],map.getOrDefault(str[1],0)+1);
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
