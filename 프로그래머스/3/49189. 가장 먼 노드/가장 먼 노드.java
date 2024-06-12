import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
                int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int L = 1;
        int[] arr = new int[n+1];
        arr[1] = 1;
        while(!q.isEmpty()){
            int m = q.poll();
            for(int i:graph.get(m)){
                if(arr[i]==0){
                    q.add(i);
                    arr[i] = arr[m]+1;
                    L = arr[m]+1;
                }
            }
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] == L) answer++;
        }
        return answer;
    }
}
