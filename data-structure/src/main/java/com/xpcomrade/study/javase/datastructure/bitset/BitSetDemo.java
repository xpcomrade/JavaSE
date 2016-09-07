package com.xpcomrade.study.javase.datastructure.bitset;

import java.util.BitSet;


/**
 * Create by Jesse
 * Date：7:50:44 PM，Aug 7, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(这里用一句话描述这个类的作用). <br/> 
 */
public class BitSetDemo {
	private BitSet used = new BitSet();

	/**
	 * 求一个字符串包含的char
	 * 
	 */
	public void contrainChars(String str) {
		for (int i = 0; i < str.length(); i++)
			used.set(str.charAt(i)); // set bit for char

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int size = used.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (used.get(i)) {
				sb.append((char) i);
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	/**
	 * 求素数 有无限个。一个大于1的自然数，如果除了1和它本身外，不能被其他自然数整除(除0以外）的数称之为素数(质数） 否则称为合数
	 */
	public void computePrime() {
		BitSet sieve = new BitSet(1024);
		int size = sieve.size();
		for (int i = 2; i < size; i++)
			sieve.set(i);
		int finalBit = (int) Math.sqrt(sieve.size());

		for (int i = 2; i < finalBit; i++)
			if (sieve.get(i))
				for (int j = 2 * i; j < size; j += i)
					sieve.clear(j);

		int counter = 0;
		for (int i = 1; i < size; i++) {
			if (sieve.get(i)) {
				System.out.printf("%5d", i);
				if (++counter % 15 == 0)
					System.out.println();
			}
		}
		System.out.println();
	}

	/**
	 * 简单使用示例
	 */
	public void simpleExample() {
		String names[] = { "Java", "Source", "and", "Support" };
		BitSet bits = new BitSet();
		for (int i = 0, n = names.length; i < n; i++) {
			if ((names[i].length() % 2) == 0) {
				bits.set(i);
			}
		}

		System.out.println(bits);
		System.out.println("Size : " + bits.size());
		System.out.println("Length: " + bits.length());
		for (int i = 0, n = names.length; i < n; i++) {
			if (!bits.get(i)) {
				System.out.println(names[i] + " is odd");
			}
		}
		BitSet bites = new BitSet();
		bites.set(0);
		bites.set(1);
		bites.set(2);
		bites.set(3);
		bites.andNot(bits);
		System.out.println(bites);
	}

	public static void main(String args[]) {
		/*BitSetDemo bs = new BitSetDemo();
		bs.contrainChars("How do you do? 你好呀");
		bs.computePrime();
		bs.simpleExample();*/
		/*System.out.println(20>>5);
		System.out.println(20 / 32);*/
		
		System.out.println(3 & 1);
		System.out.println(3 >> 1);
	}
}
