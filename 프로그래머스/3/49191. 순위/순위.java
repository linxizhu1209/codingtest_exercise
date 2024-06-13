class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];
        for(int i=0;i< results.length;i++){
            graph[results[i][0]-1][results[i][1]-1]=1;
            graph[results[i][1]-1][results[i][0]-1]=-1;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                for(int z=0;z<n;z++){
                    if(graph[i][j]==1&&graph[j][z]==1){
                        graph[i][z]=1;
                        graph[z][i]=-1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(graph[i][j]!=0) count++;
            }
            if(count==n-1) answer++;
        }
        return answer;
    }
}