import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Long> lsum = new ArrayList<>();
    static ArrayList<Long> rsum = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0,n/2,0L,lsum); // 왼쪽 부분 배열의 조합들
        dfs(n/2,n,0L,rsum);  // 오른쪽 부분 배열의 조합들

        Collections.sort(lsum);
        int answer = 0;
        for(Long partSum:rsum){ // 오른쪽 부분 배열의 조합 중 C를 초과하지 않는 값들 골라서 lsum 요소들과 비교
            if(partSum<=c){
                int start = 0;
                int end = lsum.size();

                while(start<end){
                    int mid = (start+end)/2;

                    if(lsum.get(mid)+partSum>c) end = mid;
                    else start = mid+1;
                }

            answer += end;
            }
        }

        System.out.println(answer);
    }

    static private void dfs(int s, int e, Long sum, ArrayList<Long> list){
        if(s>=e){
            list.add(sum);
            return;
        }
        dfs(s+1,e,sum,list); // 시작 인덱스번호만 바뀌기 & 현재 인덱스 조합에 포함x
        dfs(s+1,e,sum+arr[s],list); // 시작 인덱스번호 바꾸기 & 현재 인덱스 조합에 포함o
    }

}
