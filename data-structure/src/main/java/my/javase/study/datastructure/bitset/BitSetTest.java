package my.javase.study.datastructure.bitset;

import org.junit.Test;

import java.util.BitSet;



/** 
 * Created by wangzp
 * Date: 6:12:32 PM, Aug 7, 2014  
 * Copyright (c) 2014, wangzhongping@ddmap.com All Rights Reserved. 
 * TODO:(这里用一句话描述这个类的作用). <br/> 
 */
public class BitSetTest {
	@Test
	public void bitSetTest1(){
		BitSet bs=new BitSet();  
        System.out.println(bs.isEmpty()+"--"+bs.size());  
        bs.set(0);  
        System.out.println(bs.isEmpty()+"--"+bs.size());  
        bs.set(1);  
        System.out.println(bs.isEmpty()+"--"+bs.size());  
        System.out.println(bs.get(65));  
        System.out.println(bs.isEmpty()+"--"+bs.size());  
        bs.set(65);  
        System.out.println(bs.isEmpty()+"--"+bs.size());  
        
        System.out.println(1l << 6);
	}
	
	@Test
	public void bitSetTest2(){
		int[] array = new int[]{1,23,43,56,72,2,67,90};
		BitSet bs = new BitSet(array.length);
		
		for(int i : array){
			bs.set(i);
		}
		
		System.out.println(bs.toString());
		
		System.out.println(8 >> 6);
	}
}
