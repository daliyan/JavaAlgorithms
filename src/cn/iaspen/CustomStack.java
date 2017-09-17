package cn.iaspen;

/**
 * <pre>
 *  ջ�ṹ���Ƚ����
 *  ʵ��Ҫ�㣺
 *    1.����洢����
 *    2.�Զ�����
 *    3.��ջ�ǵ�������ã���ֹ�ڴ�й©
 *  ��ע�� Ҳ����ʹ������ʽʵ�֣�Ч�ʸ��� {@link LinkedStack}}
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
        stacks[size] = null;// �����������Ӧ����ֵ���ڣ�
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
        System.out.println("��������"+stacks.length);
    }

    private void checkSizeAndResize(){
       if(size == stacks.length){
           resize(size()+10);
       }
    }
    
     /**
      * ���Է���
      * @param args
      */
	public static void main(String[] args) {
		final CustomStack<String> stack = new CustomStack<>();
		for(int i=0;i<200;i++) {
			stack.push("str"+i);
		}
		System.out.println("���ȣ�"+stack.size());
		
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

