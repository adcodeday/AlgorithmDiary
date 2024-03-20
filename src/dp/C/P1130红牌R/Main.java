package dp.C.P1130红牌R;

import java.util.Scanner;

//https://www.luogu.com.cn/problem/P1130
//不知道为啥内存超了，可能是因为使用的是java的问题

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[][] co=new int[2002][2002];
        int[][] dp=new int[2002][2002];
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                co[i][j]=scanner.nextInt();
        for(int i=0;i<M;i++)
            dp[i][0]=co[i][0];
        for(int i=1;i<N;i++)
            for(int j=0;j<M;j++){
                int j1=((j-1>=0)?j:M);
                dp[j][i]=Math.min(dp[j1-1][i-1],dp[j][i-1])+co[j][i];
            }
        int min=9999999;
        for(int i=0;i<M;i++)
            min=Math.min(min,dp[i][N-1]);
        System.out.println(min);
    }
}
