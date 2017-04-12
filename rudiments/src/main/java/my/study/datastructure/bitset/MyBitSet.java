package my.study.datastructure.bitset;

import java.io.Serializable;

/**
 * Create by Jesse
 * Date：10:25:59 PM，Aug 8, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(这里用一句话描述这个类的作用). <br/> 
 */
public class MyBitSet implements Serializable {
	
	private static final long serialVersionUID = -2240079900144912505L;
	
	private long[] bitset;
	
	public MyBitSet(int nbits){
		if (nbits < 0) {
		    throw new NegativeArraySizeException("nbits < 0: " + nbits);
		}
		
		init(nbits);
	}
	
	public void set(int bitIndex){
		if (bitIndex < 0 ) {
			throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
		}
		int wordIndex = wordIndex(bitIndex);
		System.out.println(bitset[wordIndex]);
		bitset[wordIndex] |= (1L << bitIndex);
	}
	
	private void init(int nbits){
		//实例化一个long型数组 
		bitset = new long[wordIndex(nbits - 1) + 1];
	}
	
	private int wordIndex(int nbits){
		//nbits 向右移动6位 等价于 nbits / 64;
		return nbits >> 6;
	}
	
	public static void main(String[] args) {
		MyBitSet bitSet = new MyBitSet(5);
		bitSet.set(3);
	}
}
