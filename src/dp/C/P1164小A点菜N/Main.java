package dp.C.P1164小A点菜N;
import java.util.Scanner;

//（1）if(j==第i道菜的价格)f[i][j]=f[i-1][j]+1;
//（2）if(j>第i道菜的价格) f[i][j]=f[i-1][j]+f[i-1][j-第i道菜的价格];
//（3）if(j<第i道菜的价格) f[i][j]=f[i-1][j];
//https://www.luogu.com.cn/problem/P1164
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] f =new int[101][10001];
        int[] a=new int[101];
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        for(int i=1;i<n+1;i++){
            a[i]=scanner.nextInt();
        }
        for(int i=1;i<n+1;i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j == a[i]) {
                    f[i][j] = f[i - 1][j] + 1;
                }
                if (j > a[i]) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - a[i]];
                }
                if(j<a[i]) {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
