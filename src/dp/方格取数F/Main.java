package dp.方格取数F;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class DBpoint{
        int value=0;
        boolean dire=false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        //建立地图
        ArrayList<ArrayList<Integer>> board=initBoard(n,n,new intFa());
        //初始化地图
        prepareBoard(board);
        //初始化dp数组
        ArrayList<ArrayList<DBpoint>> arr=initBoard(n,n,new poFa());
        //第一次dp
        //第二次dp
        //输出最终值
        System.out.println(dp(board,arr)+dp(board,arr));
        //测试输出

    }
    static private <T> ArrayList<ArrayList<T>> initBoard(int N,int M,Factory factory){
        ArrayList<ArrayList<T>> arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<T> a=new ArrayList<>();
            for(int j=0;j<M;j++){
                a.add((T) factory.get());
            }
            arr.add(a);
        }
        return arr;
    }
    public Integer getint(){
        return 0;
    }

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
    static private int dp(ArrayList<ArrayList<Integer>> board,ArrayList<ArrayList<DBpoint>> arr){
        //填入初始值
        arr.get(0).get(0).value=board.get(0).get(0);
        for(int i=1;i<board.size();i++){
            arr.get(i).get(0).value=board.get(i).get(0)+arr.get(i-1).get(0).value;
            arr.get(i).get(0).dire=true;
        }
        for(int i=1;i<board.get(0).size();i++){
            arr.get(0).get(i).value=board.get(0).get(i)+arr.get(0).get(i-1).value;
            arr.get(0).get(i).dire=false;
        }
        //核心DP
        for(int i=1;i<board.size();i++){
            for(int j=1;j<board.get(0).size();j++){
                DBpoint t=arr.get(i).get(j);
                DBpoint up=arr.get(i-1).get(j);
                DBpoint left=arr.get(i).get(j-1);
                if(up.value>left.value){

                }
            }
        }
            return 0;
    }
    abstract static class Factory{
        abstract public Object get();
    }
    static class intFa extends Factory{
        @Override
        public Integer get() {
            return 0;
        }
    }
    static class poFa extends Factory{
        @Override
        public  DBpoint get() {
            return new DBpoint();
        }
    }
    static private void test(){

    }
}
