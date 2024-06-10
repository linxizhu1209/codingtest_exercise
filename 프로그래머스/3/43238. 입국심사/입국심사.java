import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long lt = 0;
        long rt = (long) n * times[times.length-1];
        long length = times.length;
        while(lt<=rt){
            long mid = (lt+rt)/2;
            long sum = 0;
            for(int i=0;i<length;i++){
                sum += mid/times[i];
            }
            if(sum<n) lt = mid+1;
            else {
                rt = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}