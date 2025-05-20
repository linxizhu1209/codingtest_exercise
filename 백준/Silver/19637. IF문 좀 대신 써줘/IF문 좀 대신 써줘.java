import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        /**
         * 1. 칭호의 개수 n, 칭호 출력해야하는 인원수 m
         * 2. 2번째줄부터 n개의 칭호와 칭호의 전투력 상한값이 주어짐
         * 3. 그다음줄부터 m개의 줄에는 캐릭터의 전투력을 나타내는 음이아닌 정수가 주어짐
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        String[] titles = new String[n];
        int[] limits = new int[n];
        for(int i=0;i<n;i++){
            token = new StringTokenizer(br.readLine());
            String name = token.nextToken();
            titles[i] = name;
            limits[i] = Integer.parseInt(token.nextToken());
        } // 일단 energy (전투력) 가 큰 순서대로 체크해야하지않나
        // map에 키를 별칭, 값을 전투력으로 두고, 전투력이 큰 순서대로 정렬. value를 하나씩 돌면서 그 value보다 큰지 체크
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<m;i++){
            int power = Integer.parseInt(br.readLine());
            int idx = binarySearch(limits, power);
            bw.write(titles[idx] + "\n");
            }
        bw.flush();
        bw.close();
    }
    
    static int binarySearch(int[] limits, int power){
        int low = 0;
        int high = limits.length - 1;
        int result = 0;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(limits[mid]>=power){ // mid보다 내 전투력이 약하면, mid가 일단 내칭호.
                result = mid;
                high = mid - 1; // 근데 더~ 작은 칭호도 만족을 못할수도 있으니까 더 밑으로
            } else{
                low = mid + 1;
            }
        }
        return result;
    }
    
}