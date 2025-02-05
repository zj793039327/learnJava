/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangjing56 on 2020-07-21.
 */
public class BinaryTree {
    static class Node {
        Node left;
        Node right;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static void posOrderUnRecur(Node head) {
        System.out.println("pos-order");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.empty()) {
                System.out.print(s2.pop().data + ",");
            }
        }
    }

    public static List<Integer> f(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Node> tmp = new LinkedList<>();
        //        tmp.addLast(root);
        Node cur = root;
        while (!tmp.isEmpty() || cur!=null){
            if (cur != null) {
                tmp.addLast(cur);
                cur = cur.left;
            } else {
                cur = tmp.removeLast();
                ans.add(cur.data);
                cur = cur.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //        posOrderUnRecur(root);
        System.out.println(f(root));
    }
}
