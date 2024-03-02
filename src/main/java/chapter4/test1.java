package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {
    // 강의 참고 코드
    public char solution(int n, String str){
        char answer=' ';
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x: str.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1); // getOrDefault 는 있으면 x의 value, 없으면 default값을 반환함
        }
        // map.containsKey('A')); -> 해당 key가 존재하는지 확인하고 boolean값을 return해줌
        // map.size() -> key의 개수를 알려줌
        // map.remove('A') -> 특정 KEY를 삭제함
        int max = Integer.MIN_VALUE;
        for(char key: map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                answer=key;
            }
        }
        return answer;
    }

    // 내가 짠 코드
//    public String solution(int n, String str){
//        int answer = 0;
//        String result = "";
//        int A=0;
//        int B=0;
//        int C=0;
//        int D=0;
//        int E=0;
//
//        for(char x: str.toCharArray()){
//            if(x=='A') A++;
//            else if(x=='B') B++;
//            else if(x=='C') C++;
//            else if(x=='D') D++;
//            else E++;
//        }
//
//        Map<String,Integer> list = new HashMap<>();
//        list.put("A",A);
//        list.put("B",B);
//        list.put("C",C);
//        list.put("D",D);
//        list.put("E",E);
//
//        for(String x:list.keySet()){
//            if(list.get(x)>answer){
//                answer = list.get(x);
//                result = x;
//            }
//        }
//        return result;
//    }


    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();
        System.out.print(T.solution(num,str));
    }
}

