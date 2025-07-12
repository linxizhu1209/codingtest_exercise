import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        // 1,2,3,4 push * 4 -> 4,3 pop pop, 5,6 push * 2 -> 6 pop -> 7,8 push * 2 -> 8,7 pop * 2
        /**
         * 주어진 수가 push할 수(pushNum)보다 크면 해당 숫자까지 push 후 pop. 만약 주어진 수가 pushNum보다 작다면 해당 숫자 나올때까지 pop
         * 만약 for문이 끝나기전에 stack이 비어버리면 flag true로 바꾸고 No 출력, for문이 무사히 끝나면 bw.flush로 출력
         */
        long pushNum = 1;
        Stack<Long> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        boolean flag = false;
        for(int i=0; i<n; i++){
            flag = false;
            int x = Integer.parseInt(in.readLine());
            if(pushNum<x){
                while (pushNum<x) {
                    stack.push(pushNum);
                    pushNum++;
                    list.add("+");
                }
                if(pushNum == x){
                    stack.push(pushNum); /// 1,2,3 , 5
                    pushNum++;
                    list.add("+");
                    stack.pop();
                    list.add("-");
                    flag = true;
                }
            } else if(pushNum == x){
                stack.push(pushNum);
                pushNum++;
                list.add("+");
                stack.pop();
                list.add("-");
                flag = true;
            } else if(pushNum>x){
                if(stack.isEmpty()) break;
                while(!stack.isEmpty()){
                    long y = stack.pop();
                    list.add("-");
                    if(y==x){
                        flag = true;
                        break;
                    }
                }
            }

        }
        if(flag){
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("NO");

        }

//        bw.close();
    }
}