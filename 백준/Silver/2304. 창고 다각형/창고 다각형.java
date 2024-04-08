import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 *
 *
 */
class Height implements Comparable<Height>{
    int p; // 기둥의 위치(왼쪽벽면)
    int h; // 기둥의 높이

    public Height(int p, int h) {
        this.p = p;
        this.h = h;
    }

    @Override
    public int compareTo(Height o) {
        return this.p-o.p; // 기둥의 위치순으로 정렬
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Height> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(token.nextToken());
            int h = Integer.parseInt(token.nextToken());
            list.add(new Height(p, h));
            max = Math.max(max, h); // max의 가로가 2이상인 경우도 고려해봐야한다 또한 max가 두번 등장할때 처음 max를 저장해놓도록 해야함
            end = Math.max(end, p);
        }
        Collections.sort(list);
        int maxEnd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(list.get(i).h==max){
                maxEnd = i;
            }
        }

        int sum = 0;
        for(int i=0;i<maxEnd;i++) {
            for (int j = i+1; j <= maxEnd; j++) {
                if (list.get(i).h <= list.get(j).h) {
                    int width = list.get(j).p-list.get(i).p;
                    sum += width*list.get(i).h;
                    i = j;
                }
            }
        }
        for(int i=n-1;i>maxEnd;i--){
            for(int j=i-1;j>=maxEnd;j--){
                if(list.get(i).h<=list.get(j).h){
                    int width = list.get(i).p-list.get(j).p;
                    sum+= width*list.get(i).h;
                    i = j;
                }
            }


        }
        bw.write(max+sum + "\n"); // max를 해주는 이유는 왼쪽 벽을 기준으로 계산하므로 가로가 1인 max지점은 계산이 안될것이므로
        bw.close();
    }
}
