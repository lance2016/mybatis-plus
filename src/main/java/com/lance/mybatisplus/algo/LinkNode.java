package com.lance.mybatisplus.algo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: mybatisplus  LinkNode
 * @description:
 * @author: flchen
 * @create: 2021-10-22 11:55
 **/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LinkNode {
    private int val;
    private LinkNode next;
}
