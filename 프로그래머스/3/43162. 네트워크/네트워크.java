class Solution {
    static int[] ch;
    static int count = 0;
    public int solution(int n, int[][] computers) {
         ch = new int[n];
        for(int i=0;i<n;i++){
            if(ch[i]==0){
                ch[i]=1;
                DFS(n,i,computers);
                count++;
            }
        }
        return count;
    }
       public void DFS(int n,int s, int[][] computers){
        for(int i=0;i<n;i++){
            if(computers[s][i]==1&&ch[i]==0) {
                ch[i] = 1;
                DFS(n, i,computers);
            }
        }
    }
    
}