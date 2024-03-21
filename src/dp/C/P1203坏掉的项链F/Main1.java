package dp.C.P1203坏掉的项链F;

import java.util.Scanner;
//屎山，慎看
//第一行一个正整数n ，表示珠子数目。 第二行一串长度为n 的字符串, 每个字符是 r ， b 或 w。
public class Main1 {
    static int n;
    static int N(int index){
        if(index==n-1) return 0;
        else return index+1;
    }
    static int P(int index){
        if(index==0) return n-1;
        else return index-1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        char[] chars=new char[350];
        String s=new String();
        s=scanner.next();
        int[] left=new int[n];
        int[] right=new int[n];
        int f=0;
        int count=0;
        left[0]=1;
        while((s.charAt(f)==s.charAt(P(f))||s.charAt(P(f))=='w'||s.charAt(f)=='w')&&count<n-1){
            left[0]++;
            f=P(f);
            count++;
        }
        int leftlastindex=f;
        f=n-1;
        count=0;
        right[n-1]=1;
        while((s.charAt(f)==s.charAt(N(f))||s.charAt(N(f))=='w'||s.charAt(f)=='w')&&count<n-1){
            right[n-1]++;
            f=N(f);
            count++;
        }
        int rightlastindex=f;

        if(left[0]==n){
            System.out.println(n);
            return;
        }
        for (int i=1;i<n;i++){
            if(s.charAt(i)=='w')
                left[i]=left[i-1]+1;
            else if(s.charAt(i)==s.charAt(leftlastindex)){
                left[i]=left[i-1]+1;
                leftlastindex=i;
            }
            else if(s.charAt(i)!=s.charAt(leftlastindex)){
                int j=i;
                while (s.charAt(P(j))=='w'){
                    left[i]++;
                    j=P(j);
                }
                left[i]++;
                leftlastindex=i;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='w')
                right[i]=right[i+1]+1;
            else if(s.charAt(i)==s.charAt(rightlastindex)){
                right[i]=right[i+1]+1;
                rightlastindex=i;
            }
            else if(s.charAt(i)!=s.charAt(rightlastindex)){
                int j=i;
                while (s.charAt(N(j))=='w'){
                    right[i]++;
                    j=N(j);
                }
                right[i]++;
                rightlastindex=i;
            }
        }
        int max=right[0]+left[n-1];
//        for(int i=0;i<n;i++)
//            System.out.print(left[i]+" ");
//        System.out.println();
//        for(int i=0;i<n;i++)
//            System.out.print(right[i]+" ");
        for(int i=1;i<n;i++){
            max=Math.max(left[i-1]+right[i],max );
        }
        System.out.println(max);
    }
}
