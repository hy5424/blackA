package com.lc.hb.test;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import com.lc.common.constants.ChessConstants;

public class Test {
//0'1'2'3    4'5'6'7    8'9'10'11 
	@org.junit.Test
    public void test() throws Exception {
		List<Integer> list =  ChessConstants.putPock();// 一个空的扑克牌盒子
		Collections.shuffle(list);// 将ArrayList随机打乱，模拟洗牌
		TreeSet<Integer> one = new TreeSet<Integer>(); // 玩家1的牌
        TreeSet<Integer> two = new TreeSet<Integer>(); // 玩家2的牌
        TreeSet<Integer> three = new TreeSet<Integer>(); // 玩家3的牌
        TreeSet<Integer> four = new TreeSet<Integer>(); // 玩家4的牌
        for (int i = 0; i < 40; i++) { // 模拟发牌
        	if(i<10){
        		one.add(list.get(i));
        		continue;
        	}
        	if(i<20){
        		two.add(list.get(i));
        		continue;
        	}
        	if(i<30){
        		three.add(list.get(i));
        		continue;
        	}
        	if(i<40){
        		four.add(list.get(i));
        		continue;
        	}
        }
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }

}
