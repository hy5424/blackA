package com.lc.common.constants;

import java.util.ArrayList;
import java.util.List;

public class ChessConstants {
    // 黑桃 B 红桃 R 梅花 P 方块 D

    public static final int B_5 = 51;
    public static final int R_5 = 52;
    public static final int P_5 = 53;
    public static final int D_5 = 54;

    public static final int B_6 = 61;
    public static final int R_6 = 62;
    public static final int P_6 = 63;
    public static final int D_6 = 64;

    public static final int B_7 = 71;
    public static final int R_7 = 72;
    public static final int P_7 = 73;
    public static final int D_7 = 74;

    public static final int B_8 = 81;
    public static final int R_8 = 82;
    public static final int P_8 = 83;
    public static final int D_8 = 84;

    public static final int B_9 = 91;
    public static final int R_9 = 92;
    public static final int P_9 = 93;
    public static final int D_9 = 94;

    public static final int B_10 = 101;
    public static final int R_10 = 102;
    public static final int P_10 = 103;
    public static final int D_10 = 104;

    public static final int B_J = 111;
    public static final int R_J = 112;
    public static final int P_J = 113;
    public static final int D_J = 114;

    public static final int B_Q = 121;
    public static final int R_Q = 122;
    public static final int P_Q = 123;
    public static final int D_Q = 124;

    public static final int B_K = 131;
    public static final int R_K = 132;
    public static final int P_K = 133;
    public static final int D_K = 134;

    public static final int B_A = 141;
    public static final int R_A = 142;
    public static final int P_A = 143;
    public static final int D_A = 144;
    
    public static List putPock(){
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(B_5);list.add(B_6);list.add(B_7);list.add(B_8);list.add(B_9);list.add(B_10);list.add(B_J);list.add(B_Q);list.add(B_K);list.add(B_A);
    	list.add(R_5);list.add(R_6);list.add(R_7);list.add(R_8);list.add(R_9);list.add(R_10);list.add(R_J);list.add(R_Q);list.add(R_K);list.add(R_A);
    	list.add(P_5);list.add(P_6);list.add(P_7);list.add(P_8);list.add(P_9);list.add(P_10);list.add(P_J);list.add(P_Q);list.add(P_K);list.add(P_A);
    	list.add(D_5);list.add(D_6);list.add(D_7);list.add(D_8);list.add(D_9);list.add(D_10);list.add(D_J);list.add(D_Q);list.add(D_K);list.add(D_A);
    	return list;
    }
    

}
