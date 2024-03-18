package dp.C.过河卒R;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Point{
        public int value=0;
        public boolean flag=true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x,y,m,n;
        x=scanner.nextInt();
        y=scanner.nextInt();
        m=scanner.nextInt();
        n=scanner.nextInt();
        if(m>x||n>y){
            return;
        }
        //初始化棋盘
        ArrayList<ArrayList<Point>> arr=initboard(x,y);
        //删除不可通过点
        deletePoint(m,n,arr);
        //进行dp
        System.out.println(dp(arr));
        for(int i=0;i<x+1;i++){
            for (int j=0;j<y+1;j++){
                System.out.print(arr.get(i).get(j).value+" ");
            }
            System.out.println(" ");
        }
    }
    private static ArrayList<ArrayList<Point>> initboard(int x, int y) {
        ArrayList<ArrayList<Point>> arr=new ArrayList<>();
        //构建一个x+1，y+1大小的棋盘
        for(int i=0;i<x+1;i++){
            ArrayList<Point> a=new ArrayList<>();
            for(int j=0;j<y+1;j++){
                //全部节点初始化为0
                a.add(new Point());
            }
            arr.add(a);
        }
        return arr;
    }
    private static void deletePoint(int m, int n, ArrayList<ArrayList<Point>> arr) {
        arr.get(m).get(n).flag=false;
        for(int i=-1;i<=1;i=i+2){
            for(int j=-2;j<=2;j=j+4){
                try{
                    arr.get(m+i).get(n+j).flag=false;
                } catch (Exception ignored) {}
                try{
                    arr.get(m+j).get(n+i).flag=false;
                } catch (Exception ignored) {}
            }
        }
    }
    private static int dp(ArrayList<ArrayList<Point>> arr){
        int x=arr.size();
        int y=arr.get(0).size();
        //初始化第一列
        for(int i=0;i<x;i++){
            if(arr.get(i).get(0).flag)
                arr.get(i).get(0).value=1;
            else break;
        }
        //初始化第一行
        for(int i=0;i<y;i++){
            if(arr.get(0).get(i).flag)
                arr.get(0).get(i).value=1;
            else break;
        }
        //dp整张棋盘
        for(int i=1;i<x;i++)
            for(int j=1;j<y;j++){
                Point point=arr.get(i).get(j);
                if(point.flag){
                    point.value=arr.get(i-1).get(j).value+arr.get(i).get(j-1).value;
                }
            }
        return arr.get(x-1).get(y-1).value;
    }
}
