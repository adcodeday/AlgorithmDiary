package dp.P1044栈R;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<Integer> dp=new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for(int i=0;i<n;i++){
            dp.add(0);
        }
        for (int i=2;i<=n;i++){
            int value=0;
            for(int j=1;j<=i;j++){
                value=dp.get(j-1)* dp.get(i-j)+value;
            }
            dp.set(i,value);
        }
        System.out.println(dp.get(n));
    }
}
