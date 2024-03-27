package backjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class sumCount {
    public static void main(String[] args) {
        Map<String,Double> standardGrade = new HashMap<>();
        standardGrade.put("A+",4.5); standardGrade.put("A0",4.0);
        standardGrade.put("B+",3.5); standardGrade.put("B0",3.0);
        standardGrade.put("C+",2.5); standardGrade.put("C0",2.0);
        standardGrade.put("D+",1.5); standardGrade.put("D0",1.0);
        standardGrade.put("F",0.0);
        Scanner in = new Scanner(System.in);
        double sum과평 = 0;
        double sum학점 = 0;
        double sum총점 = 0;
        for(int i=0;i<20;i++){
            String subject = in.next();
            double total = in.nextDouble();
            String grade = in.next();
            if(!grade.equals("P")) {
                sum과평 += standardGrade.get(grade); // A+를 환산한 값
                sum학점 += total; // 현 과목의 학점
                sum총점 += total * standardGrade.get(grade); // 학점 * 내가 받은 평점
            }
        }
        System.out.println((float)(sum총점/sum학점));
    }
}
