
import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 이전 단어를 기억해뒀다가 현재 단어 != 이전 단어인 경우, 이전단어는 끝난것이므로 map에 1 체크
     * 2. map에서 해당 단어를 가져왔는데 1이라면 연속성이 없는것이므로 패스
     */


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int count = 0;
        for(int i=0; i<n; i++){
            Map<Character, Integer> map = new HashMap<>();
            String str = in.readLine();
            char bfchar = str.charAt(0);
            boolean isRelay = true;
            for(char x: str.toCharArray()){
                if(bfchar!=x){
                    // 1. 이전 단어가 끝낫다는 것이니까 이전 단어는 map에 넣기
                    map.put(bfchar,1);
                    bfchar = x;
                    if(map.containsKey(x)){
                        // 이미 앞에 단어가 있었다는 것이므로
                        isRelay = false;
                        break;
                    }

                }
            }

            if(isRelay){
                count++;
            }
        }
        System.out.println(count);
    }
}