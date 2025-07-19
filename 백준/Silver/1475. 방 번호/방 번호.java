
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        Map<Integer, Integer> map = new HashMap<>();
        for(char x: n.toCharArray()) {
            int y = x-'0';
            if(y == 6){
                int a = map.getOrDefault(y, 0);
                int b = map.getOrDefault(9, 0);
                if(a>b) map.put(9, b+1);
                else map.put(y, a+1);
            } else if(y==9){
                int a = map.getOrDefault(y, 0);
                int b = map.getOrDefault(6, 0);
                if(a>b) map.put(6, b+1);
                else map.put(y, a+1);
            } else {
                map.put(y, map.getOrDefault(y, 0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=9;i++){
            int a = map.getOrDefault(i,0);
            max = Math.max(max,a);
        }
        System.out.println(max);
    }
}
