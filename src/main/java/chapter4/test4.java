package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test4 {
    // 강의 참고 코드
    public int solution(String a, String b){
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char x: b.toCharArray()){
            bm.put(x,bm.getOrDefault(x,0)+1);
        }
        int l = b.length()-1;
        for(int i=0;i<l;i++){
            am.put(a.charAt(i),am.getOrDefault(a.charAt(i),0)+1);
        }
        int lt=0;
        for(int rt=l;rt<a.length();rt++){
            am.put(a.charAt(rt),am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) answer++; // equals로 하면 사이즈와 키에 들어있는 value의 값까지 비교해줌
            am.put(a.charAt(lt),am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }




    // 내가 짠 코드
//    public int solution(String str1, String str2){
//        int count = 0;
//        String answer = "true";
//        /**
//         * 조건 1: str1>=str2
//         * 해결 방법? str1을 test3에서 했던 것처럼 창문기법을 사용하여 str2의 길이만큼 map을 만들고 밀면서 비교?
//         */
//
//        HashMap<Character,Integer> map = new HashMap<>();
//        HashMap<Character,Integer> map2 = new HashMap<>();
//        for(int i=0;i<str2.length();i++){
//            char[] chr1 = str1.toCharArray();
//            map.put(chr1[i],map.getOrDefault(chr1[i],0)+1);
//            char[] chr2 = str2.toCharArray();
//            map2.put(chr2[i],map2.getOrDefault(chr2[i],0)+1);
//
//        }
//        for(char x:map2.keySet()){
//            if(map2.get(x)==map.get(x)){
//                answer = "true";
//            }
//            else if(map.getOrDefault(x,0)==0) answer = "false";
//            // map에 str2의 문자가 존재하지 않는 다는 것이므로 아나그램 x
//            else answer = "false";
//        }
//        if(answer=="true") count++;
//
//        int length = str2.length();
//        int p1 = 0;
//        while(p1+length<str1.length()) {
//            for (int i = length+p1; i < str1.length(); i++) {
//                char[] chr = str1.toCharArray();
//                if (map.get(chr[i - length]) == 1) map.remove(chr[i - length]);
//                else {
//                    map.put(chr[i - length], map.get(chr[i - length]) - 1); // 창문의 첫번째 것 지우고 한 칸 뒤로 미는 과정
//                }
//                map.put(chr[i], map.getOrDefault(chr[i], 0) + 1); // getOrDefault 는 있으면 x의 value, 없으면 default값을 반환함
//
//                for (char x : map2.keySet()) {
//                    if (map2.get(x) == map.get(x)) {
//                        answer = "true";
//                    } else if (map.getOrDefault(x, 0) == 0) {
//                        answer = "false";
//                        break;
//                    }
//                        // map에 str2의 문자가 존재하지 않는 다는 것이므로 아나그램 x
//                    else {
//                        answer = "false";
//                        break;
//                    }
//                }
//                if (answer.equals("true")) count++;
//                p1++;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        System.out.print(T.solution(str1,str2));
        }
}

