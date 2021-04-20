package com.lance.mybatisplus;

import com.lance.mybatisplus.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: mybatisplus  Test
 * @description:
 * @author: flchen
 * @create: 2021-04-15 00:05
 **/

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");
        User user = ac.getBean(User.class);
        System.out.println(user.getName());
        TreeNode aNode = new TreeNode(10086,null,null);
        TreeNode left = new TreeNode(2, aNode, null);
        TreeNode right = new TreeNode(3, null, aNode);
        TreeNode t = new TreeNode(1, left, right);
        TreeNode s = new TreeNode(1, left, right);
        System.out.println(new Test().isSameTree(t, s));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (isSameNode(p, q)) {
            if (p != null || q != null) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return true;
        } else {
            return false;
        }
    }

    boolean isSameNode(TreeNode p, TreeNode q) {
        return (p == null || q == null) ? (p == q) : (p.val == q.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
