package com.lc.hb.core;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 比较出牌的大小
 * @author wenxin
 *
 */
public class IsBigger {
	
	/**
	 * 判断即将出的牌是否比当前容器的牌大
	 * @return
	 */
	public static boolean IsBiggerThanLast(TreeSet<Integer> lastSet,TreeSet<Integer> choose){
		String typeCard = IsTruePoker.isTruePoker(lastSet);
		//判断牌型一致的情况
		if(typeCard.equals(IsTruePoker.isTruePoker(choose))){
			// 根据牌型来判断大小
			if (lastSet.size()==choose.size()&&isBiggerLast(lastSet, choose)) {
				return true;
			}
			return false;
		}else{    //牌型不一致的情况
			if(IsTruePoker.isTruePoker(choose).equals(IsTruePoker.ZHADAN4)){  
				return true;//炸弹4张最大
			}else if(choose.size()==3&&(!IsTruePoker.isTruePoker(lastSet).equals(IsTruePoker.LIANDUI))){
				return true;  //炸弹3不能管连对
			}else{
				return false;
			}
		}
	}

	/**
	 * 判断同一个牌型的大小
	 * @param lastSet
	 * @param choose
	 * @return
	 */
	private static boolean isBiggerLast(TreeSet<Integer> last, TreeSet<Integer> cho) {
		List<Integer> list = new ArrayList<Integer>(last);
		List<Integer> choose = new ArrayList<Integer>(cho);
		//获取集合中的最后一个元素，比较大小
		if((list.get(list.size()-1)/10)<choose.get(choose.size()-1)/10){
			return true;
		}
		return false;
	}
}
