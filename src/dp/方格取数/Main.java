package dp.方格取数;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class DBpoint{
        int value;
        boolean dire;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        //建立地图
        ArrayList<ArrayList<Integer>> board=initBoard(n);
        //初始化地图
        prepareBoard(board);
        //初始化dp数组
        ArrayList<ArrayList<Integer>> arr=initBoard(n);
        //第一次dp
        //第二次dp
        //输出最终值
        System.out.println(dp(board,arr)+dp(board,arr));
        //测试输出

    }
    static private <T> ArrayList<ArrayList<T>> initBoard(int N){
        ArrayList<ArrayList<T>> arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<T> a=new ArrayList<>();
            for(int j=0;j<N;j++){
                a.add(new T(0));
            }
            arr.add(a);
        }
        return arr;
    }
    public Integer getint(){
        return 0;
    }
    p
    static private void prepareBoard(ArrayList<ArrayList<Integer>> board){
        Scanner scanner=new Scanner(System.in);
        //循环输入
        while (true){
            int x=scanner.nextInt()-1;
            int y=scanner.nextInt()-1;
            int value=scanner.nextInt();
            if(x==-1&&y==-1&&value==-1)
                return;
            board.get(x).set(y,value);
        }

    }
    static private int dp(ArrayList<ArrayList<Integer>> board,ArrayList<ArrayList<Integer>> arr){
        //填入初始值
        arr.get(0).set(0,board.get(0).get(0));
        for(int i=1;i<board.size();i++){
            board.get(i).set(0,board.get(i-1)+)
        }
    }
    static private void test(){

    }
}
