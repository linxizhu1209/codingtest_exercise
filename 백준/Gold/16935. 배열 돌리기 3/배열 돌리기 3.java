
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = bf.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int r = Integer.parseInt(arr[2]);
        int[][] numarr = new int[n][m];
        int[][] numarr2;
        for (int i = 0; i < n; i++) {
            String[] array = bf.readLine().split(" ");
            for(int j=0;j<m;j++) {
                numarr[i][j] = Integer.parseInt(array[j]);
            }
        }
        String[] h = bf.readLine().split(" ");
        int[][] newArr;
        for(int p = 0; p < r; p++) {
            int H = Integer.parseInt(h[p]);

            newArr = new int[n][m];
                if (H == 1) {
                    for (int j = 0; j < n/2; j++) {
                        for (int k = 0; k < m; k++) {
                            newArr[j][k] = numarr[n-j-1][k];
                            newArr[n-j-1][k] = numarr[j][k];
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            numarr[j][k] = newArr[j][k];
                        }
                    }
                }
                if (H == 2) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m/2; k++) {
                            newArr[j][k] = numarr[j][m-1-k];
                            newArr[j][m-1-k] = numarr[j][k];
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            numarr[j][k] = newArr[j][k];
                        }
                    }
                }
                if (H == 3) {
                    numarr2 = new int[m][n];
                            for (int j = 0; j < n; j++) {
                                for (int k = 0; k<m; k++) {
                                    numarr2[k][n-j-1] = numarr[j][k];
                                }
                            }
                    int tmp = n;
                    n = m;
                    m = tmp;
                    numarr = numarr2;
                }
                if (H == 4) {
                    numarr2 = new int[m][n];
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k<m; k++) {
                            numarr2[m-k-1][j] = numarr[j][k];
                        }
                    }
                    int tmp = n;
                    n = m;
                    m = tmp;
                    numarr = numarr2;

                }
                if (H == 5) {
                    for (int j = n / 2; j < n; j++) {
                        for (int k = 0; k < m / 2; k++) {
                            newArr[j-n/2][k] = numarr[j][k];
                            newArr[j][k] = numarr[j][k+m/2];
                            newArr[j][k+m/2] = numarr[j-(n/2)][k+m/2];
                            newArr[j-(n/2)][k+m/2] = numarr[j-n/2][k];
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            numarr[j][k] = newArr[j][k];
                        }
                    }
                }
                if (H == 6) {
                    for (int j = n / 2; j < n; j++) {
                        for (int k = 0; k < m / 2; k++) {
                            newArr[j][k] = numarr[j-n/2][k];
                            newArr[j][k+m/2] = numarr[j][k];
                            newArr[j-(n/2)][k+m/2] = numarr[j][k+m/2];
                            newArr[j-n/2][k] = numarr[j-(n/2)][k+m/2];
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            numarr[j][k] = newArr[j][k];
                        }
                    }
                }
            }
        for(int i=0;i<numarr.length;i++){
            for(int j=0;j<numarr[i].length;j++) {
                bw.write(numarr[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.close();
}}