package chapter4;

import java.util.HashMap;
import java.util.Scanner;

public class test2 {
    // 강의 참고 코드

    // 내가 짠 코드
    public String solution(String str1, String str2) {
        String answer = "YES";
        // 강의 참고 코드
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x: str1.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(char x: str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x)==0){
                return "NO";
            }
            else{
                map.put(x,map.get(x)-1);
            }
        }


        //내가 짠 코드
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for (char x : str1.toCharArray()) {
//            map1.put(x, map1.getOrDefault(x, 0) + 1);
//        }
//        for (char x : str2.toCharArray()) {
//            map2.put(x, map2.getOrDefault(x, 0) + 1);
//        }
//        for (char key : map1.keySet()) {
//            if (map2.containsKey(key)) {
//                if (map1.get(key) != map2.get(key)) return "NO";
//            } else return "NO";
//        }
        return answer;
    }


    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        System.out.print(T.solution(str1,str2));
    }
}

