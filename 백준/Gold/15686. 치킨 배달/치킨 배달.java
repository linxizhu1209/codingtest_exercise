import java.io.*;
import java.util.ArrayList;
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int len;
    static int[] pick;
    static int m;
    static int n;
    static ArrayList<Point> house,chicken;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]); // nxn 사이즈 마을
        m = Integer.parseInt(arr[1]); // 살아남는 치킨집 개수
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] strarr = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                if(Integer.parseInt(strarr[j])==1) house.add(new Point(i,j));
                else if(Integer.parseInt(strarr[j])==2) chicken.add(new Point(i,j));
            }
        }
        len = chicken.size();
        pick = new int[m]; // 여러 치킨집중 m개를 골라 배열에 할당
        t.DFS(0,0);
        bw.write(answer+"\n");
        bw.close();
    }
    public void DFS(int L,int s){
        if(L==m){
            int sum = 0;
            for(Point hs:house){
             int distance = Integer.MAX_VALUE;
             for(int n:pick){
                 distance = Math.min(distance,Math.abs(hs.x-chicken.get(n).x)+Math.abs(hs.y-chicken.get(n).y));
             }
             sum+=distance;
            }
            answer = Math.min(answer,sum);
        }
        else{
            for(int i=s;i<len;i++){
                pick[L]=i;
                DFS(L+1,i+1);
            }
        }
    }
}
