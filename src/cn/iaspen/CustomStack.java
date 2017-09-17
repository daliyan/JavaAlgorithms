package cn.iaspen;

/**
 * <pre>
 *  栈结构：先进后出
 *  实现要点：
 *    1.数组存储数据
 *    2.自动扩容
 *    3.出栈记得清除引用，防止内存泄漏
 *  备注： 也可以使用链表方式实现，效率更高 {@link LinkedStack}}
 * </pre>
 * Created by zhiwu_yan on 2017/9/14.
 */
public class CustomStack<T> implements IStack<T>{
    private T[] stacks;
    private int size = 0;

    public CustomStack(){
       this(10);
    }

    @SuppressWarnings("unchecked")
	public CustomStack(int initCap){
        stacks = (T[]) new Object[initCap];
}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
    	return size == 0;
    }
    
    @Override
    public synchronized void push(T item) {
        checkSizeAndResize();
        stacks[size++] = item;
    }

    @Override
    public synchronized T pop() {
        T item = stacks[--size];
        stacks[size] = null;// 引用清除（对应堆中值还在）
        if(size > 0 && size == stacks.length/4){
            resize(stacks.length /2);
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max){
        T[] temp = (T[]) new Object[max];
        for(int i=0; i< size;i++ ){
            temp[i] = stacks[i];
        }
        stacks = temp;
        System.out.println("扩容至："+stacks.length);
    }

    private void checkSizeAndResize(){
       if(size == stacks.length){
           resize(size()+10);
       }
    }
    
     /**
      * 测试方法
      * @param args
      */
	public static void main(String[] args) {
		final CustomStack<String> stack = new CustomStack<>();
		for(int i=0;i<200;i++) {
			stack.push("str"+i);
		}
		System.out.println("长度："+stack.size());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					String popItem = stack.pop();
					System.out.println(Thread.currentThread()+" pop str"+popItem);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=20;i<300;i++) {
						stack.push("str"+i);
						System.out.println(Thread.currentThread()+" push str"+i);
					}
				}
			}).start();
	}
}

