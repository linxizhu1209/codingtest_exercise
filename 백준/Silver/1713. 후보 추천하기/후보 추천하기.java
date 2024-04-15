
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Candidate implements Comparable<Candidate>{
    int idx;
    int num;
    int cnt;

    public Candidate(int idx, int num, int cnt) {
        this.idx = idx;
        this.num = num;
        this.cnt = cnt;
    }


    @Override
    public int compareTo(Candidate o) {
        if(this.cnt==o.cnt) return this.idx-o.idx;
        return this.cnt-o.cnt;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 리스트의 사이즈 n으로 유지
        int m = Integer.parseInt(br.readLine()); // m번의 추천
        ArrayList<Candidate> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            boolean check = false;
            int num = Integer.parseInt(token.nextToken());
            if(list.size()<n){
                for(int j=0;j<list.size();j++) {
                    if (list.get(j).num==num) {
                        list.get(j).cnt++;
                        check = true; // 같은 숫자가 있었던 것이므로 체크해야지 이후에 중복해서 추가안함
                        break;
                    }
                }
                if(!check) list.add(new Candidate(i,num,0)); //중복된 후보가 아닐경우 리스트에 새로 추가
            }
            else{
                Collections.sort(list); // 리스트를 추천수 오름차순으로 정렬하고, 추천수가 같다면 인덱스순으로 오름차순 정렬
                for(int j=0;j<n;j++){ // 어차피 리스트의 사이즈는 n을 유지할테니 n으로 둠
                    if(list.get(j).num==num){
                        list.get(j).cnt++;
                        check = true;
                        break;
                    }
                }
                if(!check){
                    list.remove(0);
                    list.add(new Candidate(i,num,0));
                }
            }
        }
        Collections.sort(list,((o1, o2) -> o1.num-o2.num));
        StringBuilder sb = new StringBuilder();
        for(Candidate c:list){
            sb.append(c.num+" ");
        }
        System.out.println(sb);
    }
}
