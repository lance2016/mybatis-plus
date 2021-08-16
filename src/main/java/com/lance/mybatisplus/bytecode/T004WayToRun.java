package com.lance.mybatisplus.bytecode;

/**
 * -Xint： 纯解释
 * -Xmixed： 混合模式：解释器 + 热点代码编译  （默认混合模式）
 * -Xcomp： 纯编译
 **/

public class T004WayToRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
    public static void m(){
        for (int i = 0; i < 10_0000L;i++){
            long j = i%3;
        }
    }
}
