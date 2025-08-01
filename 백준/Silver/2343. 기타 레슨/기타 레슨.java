
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int[] size = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            size[i] = x;
            sum += x;
            max = Math.max(max,x);
        }
        // 일단 크기가 max보다 크고 sum보다 작으면 되나?
        int lt = max;
        int rt = sum;

        int answer = Integer.MAX_VALUE;
        while(lt<=rt){
            arr = new int[m];
            int mid = (lt+rt)/2;
            int count = 0;
            boolean isOkay = true;
            for(int i=0;i<n;i++){
                if(arr[count] +size[i] <=mid){
                    arr[count] += size[i];
                } else {
                    count++;
                    if(count>=m){
                        lt = mid+1;
                        isOkay = false;
                        break;
                    }
                    arr[count] += size[i];
                }
            }
            if(isOkay){
                answer = Math.min(answer,mid);
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
}