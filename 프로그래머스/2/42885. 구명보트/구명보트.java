import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
      int count = 0;
        int lt = 0;
        int rt = people.length-1;
        Arrays.sort(people);
        while(lt<=rt){
            if(people[lt]+people[rt]>limit){
                rt--;
                count++;
            }
            else{
                count++;
                lt++;
                rt--;
            }
        }
        return count;
    }
    }
