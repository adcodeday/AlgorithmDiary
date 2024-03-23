package dp.C.P1216数字三角形R;

import java.util.Scanner;

//https://www.luogu.com.cn/problem/P1216
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<i+1;j++)
                dp[i][j]=scanner.nextInt();
        for(int i=1;i<n;i++){
            dp[i][0]+=dp[i-1][0];
        }
        for(int i=1;i<n;i++){
            dp[i][i]+=dp[i-1][i-1];
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                dp[i][j]+=Math.max(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(dp[n-1][i],max);
        }
        System.out.println(max);
    }
}