import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            String str = bf.readLine();
            map.put(str,i);
        }
        int count = 0;
        List<String> stay = new ArrayList<>();
        for(int i=1;i<=n;i++){
            String str = bf.readLine();
            if(i>=map.get(str)){
                stay.add(str);
            }
            if(i<map.get(str)){
                count++;
            }
            else if(i>map.get(str)){
                for(int x= stay.size()-1;x>=0;x--) {
                    if(map.getOrDefault(stay.get(x), 0) > map.get(str)) {
                        count++;
                        stay.remove(stay.get(x));
                    }
                }
            }
        }
        System.out.println(count);
    }
}
