package com.joshua.chapter13;

import java.lang.reflect.Method;

// 更多关于java中的反射请看有道笔记-java中反射总结
public class Reflection {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("java.util.Arrays");

		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
