package com.lance.mybatisplus.algo.middle;

import com.lance.mybatisplus.utils.JsonUtil;
import javafx.scene.Parent;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: mybatisplus  Solution
 * @description:
 * @author: flchen
 * @create: 2021-11-18 18:41
 **/

public class Solution {

    private Parent son = new Son();
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (amount == 0) {
            return 0;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 > len2) {
            return false;
        }
        if (len1 == len2) {
            return s.equals(t);
        }
        if (len1 == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < len1; i++) {
            while (count < len2) {
                if (s.charAt(i) == t.charAt(count)) {
                    if (i == len1 - 1) {
                        return true;
                    } else {
                        count++;
                        break;
                    }
                } else {
                    count++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
       Parent son = new Solution().son;
       son.name="123";
       son.setPassword("456");
        System.out.println(JsonUtil.toJson(son));
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        executor.execute(()-> System.out.println(123));
    }

    class Parent {
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            System.out.println("调用了这个");
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            System.out.println("调用了这个");
            this.password = password;
        }
    }


    class Son extends Parent {
        private String name;
        private String password;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            System.out.println("调用了这个");
            this.name = name;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }
    }
}


