package chapter1;


import java.util.Scanner;

public class test6 {
    public String solution(String str) {
//      강의에서 알려준 코드
//      현재 문자가 처음등장하는 인덱스번호와 현재 인덱스번호가 일치하다면
//      해당 문자가 처음 등장 or 중복되지 않은 문자라는 뜻이므로 answer에 추가.
//      만약 번호가 다르다면, 중복되는 문자라는 뜻이므로 answer에서 제외 */
        String answer = "";
        for(int i=0;i<str.length();i++){
            if(str.indexOf(str.charAt(i))==i){
                answer += str.charAt(i);
            }
        }
        return answer;
    }

//    /** 내가 짠 코드 */
//        String answer="";
//        char[] x = str.toCharArray();
//        for(int i=0;i<str.length();i++){
//            if(str.indexOf(x[i])!=str.lastIndexOf(x[i])&&!answer.contains(x[i]+"")){
//                answer+=x[i];
//            }
//            else if(str.indexOf(x[i])==str.lastIndexOf(x[i])){
//                answer+=x[i];
//            }
//        }
//        return answer;
//    }
    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
