class Solution {
     public int solution(String name){
        int length = name.length();
        int move = length-1; //오른쪽으로 쭉 가는 경우 최소 이동횟수
        int answer = 0;
        for(int i=0;i<length;i++){
            answer+= Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);

            int next = i+1;
            if(next<length&&name.charAt(next)=='A'){
                while(next<name.length()&&name.charAt(next)=='A'){
                    next++;
                }
                move = Math.min(move,(i*2)+(length-next));
                move = Math.min(move,i+((length-next)*2));
            }
        }
        return answer+move;

    }
}
