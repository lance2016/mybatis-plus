package com.lance.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: mybatisplus  Student
 * @description:
 * @author: flchen
 * @create: 2021-11-18 11:51
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private String name;

    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []arr = Arrays.copyOf(cost,n+1);
        return dfs(arr,n);
    }
    int dfs(int [] cost,int n){
        if(n<=1){
            return Math.min(cost[0],cost[1]);
        }
        return Math.min(cost[n-1],cost[n-2]);
    }
}
