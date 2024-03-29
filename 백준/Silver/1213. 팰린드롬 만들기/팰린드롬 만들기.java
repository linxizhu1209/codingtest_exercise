import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for(Integer x:map.values()){
            if(x%2==1) count++;
        }
        char[] arr = new char[length];
        List<Character> keySet = map.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        if(length%2==0&&count>=1||length%2==1&&count!=1) System.out.println("I'm Sorry Hansoo");
        else{
            int i =0;
            while(i!=(length/2)) {
                for (Character x : keySet) {
                    int n = map.get(x);
                    int m = map.get(x);
                    if (n <= 1) continue;
                    for(int f=0;f<n/2;f++) {
                        arr[i] = x;
                        arr[length - i - 1] = x;
                        m = m-2;
                        map.put(x, m);
                        i++;
                    }
                }
            }
            for(char x:keySet){
                if(map.get(x)!=0) arr[length/2] = x;
            }
            for(char x: arr) {
                System.out.print(x);
            }
        }
    }
}
