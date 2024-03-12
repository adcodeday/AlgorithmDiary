//package 公用方法包.Test;
//import 公用方法包.DP公用方法.DPboard;
//import 公用方法包.DP公用方法.IterOperation;
//public class Test {
//    public static void main(String[] args) {
//        DPboard<Dppo> d = new DPboard<>(10, 10, new Dfa());
//        d.Run(100,100, new IterOperation<Dppo>() {
//            @Override
//            public void operation(Dppo th, Dppo left, Dppo up, int i, int j) {
//                th.dp=j;
//            }
//        });
//        d.Run( new IterOperation<Dppo>(){
//
//            @Override
//            public void operation(Dppo th, Dppo left, Dppo up, int i, int j) {
//                th.value=(left!=null)?left.value:0+(up!=null)?up.value
//            }
//        });
//        d.Run(20, 20, new IterOperation<Dppo>() {
//            @Override
//            public void operation(Dppo th, Dppo left, Dppo up, int i, int j) {
//                System.out.println("i:"+i+",j:"+j);
//                System.out.println(th.toS());
//            }
//        });
//    }
//}
