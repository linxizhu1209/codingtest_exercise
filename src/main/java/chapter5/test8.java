package chapter5;

import java.util.*;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}

public class test8 {
    // 강의 참고 코드
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>(); // queue 는 linkedList로 선언
        for(int i=0;i<n;i++){
            q.offer(new Person(i,arr[i]));
        }  // Person이라는 객체를 만들어, i번째 환자, i번째 환자의 우선순위로 필드를 정의한다. -> 이를 Queue에 담음
        while(!q.isEmpty()){
            Person tmp = q.poll();  // queue 처음에 위치한 Person객체를 꺼내서 tmp로 정의
            for(Person x: q){ // queue를 하나씩 돌면서 queue에 있는 객체와 tmp를 비교
                if(x.priority>tmp.priority){ // 만약 queue에 있는 객체중 tmp보다 우선순위가 높은 것이 있다면,
                    q.offer(tmp); // tmp는 다시 queue에 넣어주고
                    tmp=null; // tmp를 null로 두고 해당 for문은 끝냄
                    break;
                }
            }
            if(tmp!=null){ // 만약 queue에 tmp보다 우선순위가 높은 것이없다면, 그 tmp 객체가 가장 먼저 치료받는 것이므로 치료받았다는 의미로 answer++를 해줌
                answer++;
                if(tmp.id==m) return answer; // 그리고 해당 객체의 id(처음 왔을때 몇번째 환자였는지)가 문제에서 요구하는 m번째 환자와 동일하다면, answer을 리턴
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
    }
}

