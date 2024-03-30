import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        map.put("I",n+1);
        map.put("O",n);
        StringBuilder sb = new StringBuilder();
        int finish = 0;
        while(finish<2) {
            for (String x : map.keySet()) {
                if (map.get(x) != 0) {
                    sb.append(x);
                    map.put(x, map.get(x) - 1);
                } else finish++;
            }
        }
        int count = 0;
        String s = br.readLine();
        StringBuilder s2 = new StringBuilder(s.substring(0,(2*n)+1));
        if(s2.compareTo(sb)==0) count++;
        for(int i=(2*n)+1;i<m;i++){
            s2.replace(0,1,"");
            s2.append(s.charAt(i));
            if(s2.compareTo(sb) == 0) count++;
        }
        System.out.println(count);
    }
}
