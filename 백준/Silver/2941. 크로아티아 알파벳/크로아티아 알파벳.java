
import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 각 칸은 빈칸 또는 벽
     * 2. 동,서,남,북으로만 이동
     * 3. d가 주어지는데 0 -> 북, 1-> 동, 2-> 남, 3->서
     */
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        int lt = 0;
        int rt = 1;
        int count = 0;
        // 3글자까지 봄
        while(lt<rt && rt<=str.length()) {



            String str2 = str.substring(lt, rt);
            if(set.contains(str2)){
                for(int i=lt;i<rt;i++){
                    arr[i] = 1;
                }
                count++;
                lt = rt++;
            } else {
                rt++;
            }

            if(rt-lt >= 4 || rt > str.length()){
                if(arr[str.length()-1] != 1) {
                    count++;
                    lt++;
                    rt = lt + 1;
                }
            }

        }

        System.out.println(count);


    }

}