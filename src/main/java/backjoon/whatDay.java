package backjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class whatDay {
    public static void main(String[] args) {
        Map<Integer,String> date = new HashMap<>();
        date.put(1,"MON");date.put(2,"TUE");
        date.put(3,"WED");date.put(4,"THU");
        date.put(5,"FRI");date.put(6,"SAT");
        date.put(0,"SUN");

        Map<Integer,Integer> totalDay = new HashMap<>();
        totalDay.put(1,31); totalDay.put(2,28); totalDay.put(3,31);
        totalDay.put(4,30); totalDay.put(5,31); totalDay.put(6,30);
        totalDay.put(7,31); totalDay.put(8,31); totalDay.put(9,30);
        totalDay.put(10,31); totalDay.put(11,30); totalDay.put(12,31);
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int D = in.nextInt();
        int sum = 0;
        for(int i=1;i<M;i++){
            sum+= totalDay.get(i);
        }
        int today = sum+D;
        String todayDate = date.get(today%7);
        System.out.println(todayDate);
    }
}
