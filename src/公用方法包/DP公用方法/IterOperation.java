package 公用方法包.DP公用方法;

abstract public class IterOperation<T extends DPPo> {
    public abstract void operation(T th, T left, T up,int i,int j);
}
