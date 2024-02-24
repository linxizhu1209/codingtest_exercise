package chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test3 {
    public String solution(String str) {
//    /** 1번째방법 - 강의 참고 */
        String answer = "";
        String[] strArray = str.split(" ");
        int min = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > min) {
                min = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length()>min) answer=str;
        return answer;


//        /** 2번째 방법 - 강의 참고  */
//        for (String x : strArray) {
//            if (x.length() > min)
//                answer = x;
//                min=x.length();
//        }
//        return answer;
//    }

//        /** 3번째 방법 - 직접 만든 코드 */
//        Arrays.sort(strArray, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//        return strArray[0];
//    }
    }


    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
