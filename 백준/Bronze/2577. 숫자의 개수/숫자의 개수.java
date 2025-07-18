
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = 1;
        for(int i=0;i<3;i++){
            n *= Integer.parseInt(br.readLine());
        }

        String str = String.valueOf(n);

        Map<Integer, Integer> map = new HashMap<>();
        for(char x: str.toCharArray()){
            int y = x-'0';
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        for(int i=0;i<10;i++){
            System.out.println(map.getOrDefault(i,0));
        }


    }
}
