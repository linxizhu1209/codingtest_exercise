
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int min = Integer.MAX_VALUE;
    private static boolean[] broken;
    private static int target,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        broken = new boolean[10]; // 숫자 10개중 고장난 숫자 체크
        String[] str = new String[0];
        if(n!=0) {
            str = br.readLine().split(" ");
        }
        for(int i=0;i<n;i++){
            broken[Integer.parseInt(str[i])] = true;
        }
        result = Math.abs(target-100); // 현재 100번에서 target까지 + - 버튼으로만 이동했을 경우
        for(int i=0;i<=999999;i++){
            // 갈 수 있는 채널은 무한대만큼 있지만, 가려는 채널은 500,000 까지 범위로 제시되므로 이 두배인 1,000,000 이상은 Math.abs(target-i,target-100)을 해도 무조건 target-100이 더 작아서 판단할 이유가 없기에 두배가 되지 않는 999,999까지 for문 반복
            // 500,000까지만 판단해도되지않나 라는 생각에 500,000까지 범위를 잡았었는데 답이 안나옴==> 500,000 밑 숫자로 했을때 1,2,3,4,5가 다 고장난 번호일 수도 있기에 6,7,8,9 범위까지 확인해야한다는 걸 알게됨
            String numstr = String.valueOf(i);
            int length = numstr.length();
            boolean isbroken = false;
            for(int j=0;j<length;j++) {
                if (broken[numstr.charAt(j)-'0']) {
                    isbroken = true;
                    break; // 만약 해당 숫자중 고장난 숫자 하나라도 있으면 for문을 더 돌 필요 없이 끝내주고 다음 숫자로 간다
                }
            }
            if(!isbroken){ // 숫자 i 중에 고장난 숫자가 포함되지 않았다는 것이므로 target-i로 i에서 target까지 몇번 조작을 통해 갈 수있는지 구하고, i의 자릿수만큼 리모콘 조작을 해야하기에 이를 더해준다.
                min = Math.abs(target-i)+length;
                result = Math.min(min,result);
            }
        }
        System.out.println(result);
    }
}

