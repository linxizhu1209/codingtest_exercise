package chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class test4 {
    /** 직접 구현 한 코드
    public String[] solution(int num, String[] arr) {
        String[] answer = new String[num];
        for(int i=0;i<arr.length;i++){
            StringBuilder strRev = new StringBuilder(arr[i]);
            answer[i]=String.valueOf(strRev.reverse());
        }
        return answer;
    } */

    /** 강의 참고한 코드 */
    public ArrayList<String> solution(int num, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x:arr){
            char[] s = x.toCharArray();
            int lt=0, rt=x.length()-1;
            while(lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }
    public static void main(String[] args) {
        test4 T = new test4();
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        String[] arr = new String[num];
        for(int i=0; i<num;i++){
            arr[i] = in.next();
        }
        ArrayList<String> answer = T.solution(num,arr);
        for(String result: answer) {
            System.out.println(result);
        }
    }
}
