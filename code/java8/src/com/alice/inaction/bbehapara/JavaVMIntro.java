package com.alice.inaction.bbehapara;


/**
 * 内存介绍
 * @author xuxhm
 *
 */
public class JavaVMIntro {
	public static String staticObjVar;
	
	/**
	 * 运行时变量线程共享：字符串（"staticObjVal"）、字面量（下面的3）、类名（JavaVMIntro）、方法名：
	 * 方法区共享：类信息、常量、静态变量（staticObjVar、staticObjVal、objVal）、类方法（main）
	 */
	public static final String staticObjVal = "staticObjVal";

	public String objVar;

	public final int objVal = 3;
	
	/**
	 * 栈内存线程独有：虚拟机栈、程序计数器、本地方法栈
	 * 一个程序计数器（当前执行字节码地址）
	 * 一个线程有一个虚拟机栈
	 *    一个虚拟机栈有多个栈帧，一个栈帧对应一个方法
	 *       一个方法含：当前对象this、参数i、成员变量a、操作数栈（寄存器）、方法返回地址等
	 * @param i
	 * @return
	 */
	public int add(int i){
		int a = 0;
		return a + i;
	}
	
	public static void main(String[] args) {
		/**
		 * 堆线程共享：对象实例对象（intro）、实例变量（objVar）、数组
		 */
		JavaVMIntro intro = new JavaVMIntro();
    }
}
