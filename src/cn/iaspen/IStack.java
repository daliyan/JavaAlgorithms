package cn.iaspen;

/**
 * Created by zhiwu_yan on 2017/9/14.
 */
public interface IStack<T> {
    int size();
    boolean isEmpty();
    void push(T item);
    T pop();
}
