
import java.io.*;
import java.util.StringTokenizer;
public class Main {

    /**
     * 1. 햄버거는 한개뿐이라 맨처음에 있는 애가 이 전에껄 먹든가 해야함. 왜냐면 다음껄 먹어버리면 끝에있는사람들이 먹을게 없고, 맨처음 사람 앞에만 햄버거 남아있을듯
     * 2. k는 햄버거와의 거리
     * 3. n은 식탁의 길이
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken()); // 식탁의 길이
        int k = Integer.parseInt(token.nextToken()); // 햄버거와의 거리 (* 이 거리보다 이하인 햄버거도 먹을 수 있음)
        String str = br.readLine();
        int[] burger = new int[n]; // 버거가 있으면 1, 없으면 0
        int[] people = new int[n]; // 사람이 있으면 1, 없으면 0
        for(int i=0;i<n;i++){
            char x = str.charAt(i);
            if(x == 'H'){
                burger[i] = 1;
            }
            else if(x == 'P'){
                people[i] = 1;
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(people[i] == 1){
                // 사람이 위치한 곳 i 부터 k 거리를 좁혀가면서 햄버거 먹을수있으면 count++; 햄버거는 0으로 세팅
                boolean eaten = false;
                for(int j=i-k;j<=i-1;j++){
                        // 먼곳부터 탐색
                        if(j<0) continue;
                        if(burger[j] == 1){
                            count++;
                            burger[j] = 0;
                            eaten = true;
                            break;
                        }
                }
                if(eaten){
                    continue;
                }
                for(int j=i+1;j<=i+k;j++){
                    if(j>=n) continue;
                    if(burger[j] == 1){
                        count++;
                        burger[j] = 0;
                        eaten = true;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}