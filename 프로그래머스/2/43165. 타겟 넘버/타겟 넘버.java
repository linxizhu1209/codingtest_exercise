class Solution {
    static int[] numbers;
    static int target;
    static int count=0;
    static int length;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target; 
        this.length = numbers.length;
        DFS(0,0);
        return count;
    }
    public void DFS(int L, int sum){
        if(L==length){
            if(sum == target) count++;
        }
        else{
            DFS(L+1,sum+numbers[L]);
            DFS(L+1,sum-numbers[L]);
        }
    }
}