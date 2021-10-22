package com.lance.mybatisplus.algo.easy;

import com.lance.mybatisplus.algo.LinkNode;

/**
 * @program: mybatisplus  LinkNodeUtils
 * @description:
 * @author: flchen
 * @create: 2021-10-22 11:57
 **/

public class LinkNodeUtils {

    public static void main(String[] args) {
        LinkNode node = new LinkNode(1, new LinkNode(2, new LinkNode(3, new LinkNode(4, new LinkNode(5, null)))));
        System.out.println(node);
        LinkNode reverseNode = reverse2(node);
        System.out.println(reverseNode);
    }

    // 递归反转链表
    static LinkNode reverse(LinkNode head) {
        // 递归结束条件
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 获取剩余部分翻转后的结果
        LinkNode node = reverse(head.getNext());
//        当前节点作为翻转后节点的最后一个节点
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }

    // 头插法反转链表
    static LinkNode reverse2(LinkNode head) {
        LinkNode node = null;
        while (head != null) {
            // 先记录当前节点的下一个节点，因为下面要修改当前节点的下一个节点
            LinkNode next = head.getNext();
            // 当前节点头插法插入新的链表
            head.setNext(node);
            // node指针指向新链表头部
            node = head;
            // head向后遍历
            head = next;
        }
        return node;
    }


}
