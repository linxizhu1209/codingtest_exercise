import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        Map<String,Integer> person = new HashMap<>();
        for(int i=0;i<Integer.parseInt(arr[0]);i++){
            String str = br.readLine();
            person.put(str, person.getOrDefault(str,0)+1);
        }
        int count = 0;
        for(int i=0;i<Integer.parseInt(arr[1]);i++){
                String str = br.readLine();
                int num = person.getOrDefault(str,0)+1;
                person.put(str, num);
                if(num==2) count++;
        }
        List<String> keySet = person.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(count);
        for(String x:keySet){
            if(person.get(x)==2){
                System.out.println(x);
            }
        }
    }
}
