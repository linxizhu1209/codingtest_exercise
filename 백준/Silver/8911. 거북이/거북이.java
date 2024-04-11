import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제 해결 방식
 * 1. stack에 좌표 하나씩 저장하고 마지막 넣은 것에서 명령 적용하여 이동
 * 2. 이후에 stack을 하나씩 꺼내면서 x와 y의 최대 최소값을 구하여 절댓값으로 넓이 구해주면됨
 */

class tt{
    int x;
    int y;

    public tt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static Stack<tt> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            stack.add(new tt(0,0)); // 0,0 좌표부터 시작하니까
            char direction = 'N';
            String order = br.readLine();
            int length = order.length();
            Main t = new Main();
            for(int j=0;j<length;j++){
                if(order.charAt(j)=='L'||order.charAt(j)=='R'){
                    direction = t.rotate(direction,order.charAt(j)); // 방향을 변경하는 메서드
                }
                else{
                    t.go(direction,order.charAt(j)); // 위치 이동하는 메서드
                }
            }
            // stack을 하나씩 빼주면서 max와 min 구해야함
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            while(!stack.isEmpty()){
                tt tt = stack.pop();
                maxX = Math.max(maxX,tt.x);
                minX = Math.min(minX,tt.x);
                maxY = Math.max(maxY,tt.y);
                minY = Math.min(minY,tt.y);
            }
            int answer = Math.abs(maxX-minX)*Math.abs(maxY-minY);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private void go(char direction, char OrderGo){
        tt tt = stack.peek();
        if(direction=='N'){
            if(OrderGo=='F') stack.add(new tt(tt.x,tt.y+1));
            else stack.add(new tt(tt.x,tt.y-1));
        }
        else if(direction=='E'){
            if(OrderGo=='F') stack.add(new tt(tt.x+1,tt.y));
            else stack.add(new tt(tt.x-1,tt.y));
        }
        else if(direction=='S'){
            if(OrderGo=='F') stack.add(new tt(tt.x,tt.y-1));
            else stack.add(new tt(tt.x,tt.y+1));
        }
        else if(direction=='W'){
            if(OrderGo=='F') stack.add(new tt(tt.x-1,tt.y));
            else stack.add(new tt(tt.x+1,tt.y));
        }
    }
    private char rotate(char direction,char OrderDir){
        if(direction=='N'){
            if(OrderDir=='R') return 'E';
            else return 'W';
        }
        if(direction=='E'){
            if(OrderDir=='R') return 'S';
            else return 'N';
        }
        if(direction=='S'){
            if(OrderDir=='R') return 'W';
            else return 'E';
        }
        if(direction=='W'){
            if(OrderDir=='R') return 'N';
            else return 'S';
        }
        return direction;
    }
}
