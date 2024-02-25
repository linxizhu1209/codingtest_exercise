package chapter1;

import org.example.Main;

import java.util.Scanner;

public class test10 {
    /** 강의에서 구현한 코드 */
    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t){
                p=0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
        }
        p=1000;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==t) p = 0;
            else{
                p++;
                answer[i]=Math.min(answer[i],p);
            }
        }
        return answer;
    }




//    /** 강의 힌트 보고 직접 구현한 코드 */
//    public String solution(String str){
//        String answer = "";
//        String[] arr = str.split(" ");
//        String word = arr[0];
//        char target = arr[1].charAt(0);
//        char[] arrchar = word.toCharArray();
//        int n = 1000;
//        int[] intArr = new int[word.length()];
//        for(int i=0;i<arrchar.length;i++) {
//            if(target==arrchar[i]) {
//                n=0;
//                intArr[i]=n;
//            }
//            else{
//                n++;
//                intArr[i]=n;
//            }
//        }
//        int m = 1000;
//        for(int i=arrchar.length-1;i>=0;i--){
//            if(arrchar[i]==target){
//                m=0;
//                intArr[i]=m;
//            }
//            else{
//                m++;
//                intArr[i] = Math.min(intArr[i], m);
//            }
//        }
//        for(int x:intArr){
//            answer += x+" ";
//        }
//        return answer;
//
//    }

    public static void main(String[] args) {
        test10 T = new test10();
        Scanner in = new Scanner(System.in);
        // 내가 구현한 코드
//        String input = in.nextLine();
//        System.out.println(T.solution(input));

        // 강의 코드
        String str = in.next();
        char c=in.next().charAt(0);
        for(int x:T.solution(str,c)){
            System.out.print(x+" ");
        }
    }
}
