package backjoon.과제;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nandm9 {

    static int n;
    static int m;
    static int[] numbers;
    static int[] check;
    static int[] assemble;
    static BufferedWriter bw;
    public void DFS(int L) throws IOException {
        if(L==m){
            for(int x:assemble) {
                bw.write(x+" ");
            }
            bw.write("\n");
        }
        else{
            /**
             * 만약 1, 7, 9, 9 또는 1,1,1,1 과 같은 값이 들어왔을때
             * 이전에 출력했던 값 {1,9} 과 중복되는 일이 발생하기에,
             * 이전 for문에서 출력할 때 사용했던 값과 현재 출력할때 사용하려는 값이 같다면
             * DFS를 거치지않도록 continue를 사용
             * {9,9} 같이 원소가 중복되는 건 출력될 수 있는 이유는, before은 위에서 말한대로
             * 이전 for문에서 사용된 값을 체크하는 거지, L에 따른 값을 비교하는 게 아니기에
             * 0번 인덱스의 9는 L=0일때 for문을 돈 것이고, 1번 인덱스의 9는 L=1일때 for문을 돈 것이기에
             * 가능하다
             */
            int before = 0;
            for(int i=0;i<n;i++){
                if(before == numbers[i]){
                    continue;
                }
                if(check[i]==0) {
                    check[i]=1;
                    assemble[L] = numbers[i];
                    before = numbers[i];
                    DFS(L+1);
                    check[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
     nandm9 t = new nandm9();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        numbers = new int[n];
        check = new int[n];
        assemble = new int[m];
        token = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(numbers);
        t.DFS(0);
        bw.close();
    }
}
