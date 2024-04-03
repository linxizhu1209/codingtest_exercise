
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static boolean error;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main t = new Main();
        int n = Integer.parseInt(br.readLine());
        error = false;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().replace('[',' ').replace(']',' ').trim().split(",");
            if(num==0&&!str.contains("D")) {
                bw.write("[]"+"\n");
                continue;
            }
            else if(num==0&&str.contains("D")){
                bw.write("error"+"\n");
                continue;
            }
            int[] answer = t.solution(str,strArr);
            if(error) {
                bw.write("error"+"\n");
                error = !error;
            }
            else {
                sb.append("[");
                if(answer.length!=0) {
                    for (int x : answer) {
                        sb.append(x + ",");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("]");
                bw.write(sb.toString()+"\n");
            }
        }
        bw.close();
    }
    public int[] solution(String test,String[] arr){
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int length = arr.length;
        for(int i=0;i<length;i++){
            dq.offer(Integer.parseInt(arr[i]));
        }
        int testLength = test.length();
        boolean reverse = false;
        for(int i=0;i<testLength;i++){
            char x = test.charAt(i);
            if(x=='R'){
                reverse = !reverse;
            }
            else{
                if(dq.isEmpty()){
                    error = true;
                    return answer;
                }
                if(reverse) dq.pollLast();
                else dq.poll();
            }
        }
        answer = new int[dq.size()];
        int size = dq.size();
        for(int i=0;i<size;i++){
            if(reverse) answer[i]=dq.pollLast();
            else answer[i]=dq.poll();
        }
        return answer;
        }
    }

