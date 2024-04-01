import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Number implements Comparable<Number>{
    int number;
    int count;

    public Number(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Number o) {
        if(this.count>o.count) return this.count-o.count;
        else if(this.count==o.count) return this.number-o.number;
        else return -1;
    }
}


public class Main {
    static int r = 0;
    static int c = 0;
    static int k = 0;
    static int[][] A;
    static int xLength = 3;
    static int yLength = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        A = new int[101][101]; // 인덱스 1부터 시작하므로 100개 담으려면 101 사이즈를 만들어야함
        for(int i=1;i<=xLength;i++){
            String[] numstr = br.readLine().split(" ");
            for(int j=1;j<=yLength;j++) {
                A[i][j] = Integer.parseInt(numstr[j-1]);
            }
        }
        System.out.println(solution());
    }

    static public int solution(){
        for(int time = 0; time<=100;time++){
            if(A[r][c]==k){
                return time;
            }
            operating();
        }
        return -1;
    }

    static void operating(){
        if(xLength >= yLength){
            for(int i=1;i<=xLength;i++){
                R(i);
            }
        }
        else{
            for(int i=1;i<=yLength;i++){
                C(i);
            }
        }
    }

    static void R(int key){
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=yLength;i++){
           if(A[key][i]==0) continue;
           map.put(A[key][i],map.getOrDefault(A[key][i],0)+1);
        }
        map.forEach((k,v)->pq.add(new Number(k,v)));

        int i=1;
        while(!pq.isEmpty()){
            Number number = pq.poll();
            A[key][i++] = number.number;
            A[key][i++] = number.count;
        }
        yLength = Math.max(yLength,i);
        while(i<=99){
            A[key][i++] = 0;
            A[key][i++] = 0;
        }
    }

    static void C(int key){
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=xLength;i++){
            if(A[i][key]==0) continue;
            map.put(A[i][key],map.getOrDefault(A[i][key],0)+1);
        }
        map.forEach((k,v)->pq.add(new Number(k,v)));
        int i = 1;
        while(!pq.isEmpty()){
            Number number = pq.poll();
            A[i++][key] = number.number;
            A[i++][key] = number.count;
        }
        xLength = Math.max(xLength,i);
        while(i<=99){
            A[i++][key]= 0;
            A[i++][key]= 0;
        }
    }

}
