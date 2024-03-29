package backjoon.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class HiBear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                answer+=set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }
        answer+=set.size();
        System.out.println(answer);
    }
}
//        StringBuilder answer= new StringBuilder(" ");
//        int count = 0;
//        String str = "";
//        for(int i=0;i<n;i++){
//            str = br.readLine();
//            if(str.equals("ENTER")){
//                answer = new StringBuilder(" ");
//            }
//            else if(!answer.toString().contains(str)){
//                answer.append(str);
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}
