package chapter5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test3 {
    // 강의 참고 코드
    public int solution(int n,int[][] board, int m, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos: moves){
            for(int i=0;i<n;i++){
                if(board[i][pos-1]!=0){
                    int tmp=board[i][pos-1];
                    board[i][pos-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()){
                        answer+=2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }

            }
        }
        return answer;
    }


    // 내가 짠 코드
//    public int solution(int n,int[][] board, int m, int[] moves){
//        int answer = 0;
//        List<Integer> numList = new ArrayList<>();
//        numList.add(0);
//        // moves에 담긴 숫자는 열의 숫자,
//        for(int x:moves){
//            for(int i=0;i<n;i++){
//                if(board[i][x-1]!=0){
//                    numList.add(board[i][x-1]);
//                    board[i][x-1]=0;
//                    break;
//                }
//            }
//        }
//
//        for(int i=1;i<numList.size();i++){
//            if(numList.get(i) == numList.get(i-1)){
//                answer+=2;
//                numList.remove(i);
//                numList.remove(i-1);
//                i=1;
//            }
//
//        }
//        return answer;
//    }



    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        int[] moves = new int[m];
        for(int i=0;i<m;i++){
            moves[i] = in.nextInt();
        }
        System.out.print(T.solution(n,board,m,moves));
    }
}

