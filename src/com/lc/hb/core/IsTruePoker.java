package com.lc.hb.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class IsTruePoker {

	public final static String DANZHANG = "DANZHANG";    //单牌
	public final static String DUIZI = "DUIZI";          //对子
	public final static String ZHADAN3 = "ZHADAN3";      //3张牌炸弹
	public final static String ZHADAN4 = "ZHADAN4";      //4张牌炸弹
	public final static String SHUNZI = "SHUNZI";        //顺子
	public final static String LIANDUI = "LIANDUI";      //连对
	public final static String ERROR = "ERROR";

	/**
	 * 判断出牌时候符合规则
	 * @param treeSet
	 * @return
	 */
	public static String isTruePoker(TreeSet<Integer> treeSet){
		List<Integer> list = new ArrayList<Integer>(treeSet);
		int num = list.size();
		if(num == 1){
			return DANZHANG;
		}else if(num == 2){
			if(isSame(list,num)){
				return DUIZI;
			}else{
				return ERROR;
			}
		}else if(num == 3){
			if(isShunZi(list,num)){
				return SHUNZI;
			}else if(isSame(list,num)){
				return ZHADAN3;
			}else {
				return ERROR;
			}
		}else if(num == 4){
			if(isShunZi(list,num)){
				return SHUNZI;
			}else if(isSame(list,num)){
				return ZHADAN4;
			}else{
				return ERROR;
			}
		}else{
			if(isShunZi(list,num)){
				return SHUNZI;
			}
			if(isLianDui(list,num)){
				return LIANDUI;
			}
			return ERROR;
		}
	}

	/**
	 * 判断是否是顺子
	 * @param list
	 * @param num
	 * @return
	 */
	private static boolean isShunZi(List<Integer> list, int i) {
		for(int j=0;j<i-1;j++){
			int a=list.get(j)/10;
			int b=list.get(j+1)/10;
			if(b-a==1){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断牌是否相同
	 * @param treeSet
	 * @param num
	 * @return
	 */
	private static boolean isSame(List<Integer> list, int i) {
		for(int j=0;j<i-1;j++){
			int a=list.get(j)/10;
			int b=list.get(j+1)/10;
			if(a!=b){
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否是连对
	 * @param list
	 * @param num
	 * @return
	 */
	private static boolean isLianDui(List<Integer> list, int i) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int j=0;j<i;j++){
			if(j%2==0){
				list1.add(list.get(j)/10);
			}else{
				list2.add(list.get(j)/10);
			}
		}
		if(list1.equals(list2)){
			for(int j=0;j<list1.size()-1;j++){
				int a=list1.get(j);
				int b=list2.get(j+1);
				if(b-a==1){
					continue;
				}else{
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
