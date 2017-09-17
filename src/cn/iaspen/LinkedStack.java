package cn.iaspen;

import java.util.Stack;

/**
 * <pre>
 *  栈结构：先进后出
 *  实现要点：
 *    1.数组存储数据
 *    2.自动扩容
 *    3.出栈记得清除引用，防止内存泄漏
 *  备注： 使用链表方式实现，效率更高 {@link CustomStack}} 队列同理
 * </pre>
 * Created by zhiwu_yan on 2017/9/14.
 */
public class LinkedStack<T> implements IStack<T>{

	private Node<T> first;
	private int size;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}

	@Override
	public synchronized void push(T item) {
		// TODO Auto-generated method stub
		Node<T> oldNode = first;
		first = new Node();
		first.item = item;
		first.next = oldNode;
		size++;
	}

	@Override
	public synchronized T pop() {
		T item = first.item;
		first.next = first.next;
		size--;
		return item;
	}
	
	public static void main(String[] args) {
		final LinkedStack<String> stack = new LinkedStack();
		for(int i=0;i<2000;i++) {
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
