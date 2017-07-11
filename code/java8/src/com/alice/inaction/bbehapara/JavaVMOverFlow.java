package com.alice.inaction.bbehapara;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈、堆、方法区内存溢出
 * @author xuxhm
 *
 */
public class JavaVMOverFlow {
	
	private void dontStop() {
        while (true) {
        }
    }

	/**
	 * -Xss10m 配置栈内存
	 * java.lang.OutOfMemoryError
	 * 虚拟机栈溢出：一个线程一个虚拟机栈，包含多个栈帧，每个栈帧对应一个方法
	 * 栈帧包含：参数、局部变量、操作数栈等，需要栈溢出可以递归方法调用，使得栈帧很深，也可以循环创建线程
	 * @param args
	 */
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
	
	/**
	 * -Xss配置栈内存
	 * java.lang.StackOverflowError
	 * 虚拟机栈溢出：一个线程一个虚拟机栈，包含多个栈帧，每个栈帧对应一个方法
	 * 栈帧包含：参数、局部变量、操作数栈等，需要栈溢出可以递归方法调用，使得栈帧很深，也可以循环创建线程
	 * @param args
	 */
	public void stackLeakByParameter(){
		int a = 0;
		while(true){
			stackLeakByParameter();
		}
	}
	
	/**
	 * -XX:PermSize=10M -XX:MaxPermSize=10M 方法去配置
	 * java.lang.OutOfMemoryError: Java heap space
	 * 方法区溢出：类信息、常量、静态变量、类方法
	 * 运行时常量池：字面量（2）、符号引用、变量、类名、方法名
	 * 溢出方案：字符串多个
	 * @param args
	 */
	public void RuntimeConstantPool(){
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			//intern()查到对象，然后如果运行常量池没有存放第一次引用地址
			list.add(String.valueOf(i++).intern());
		}
	}
	
	/**
	 * -Xms10M -Xmx10M 堆内存配置
	 * java.lang.OutOfMemoryError: Java heap space
	 * 方法区溢出：对象实例、数组
	 * 溢出方案：创建多个对象
	 * @param args
	 */
	public void HeapSpace(){
		List<JavaVMOverFlow> list = new ArrayList<JavaVMOverFlow>();
		int i = 0;
		while(true){
			list.add(new JavaVMOverFlow());
		}
	}
	
	public static void main(String[] args) {
		JavaVMOverFlow test = new JavaVMOverFlow();
		test.stackLeakByThread();
    }
}
