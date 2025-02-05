/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.bt;

import org.learn.cs.problems.TreeNode;

public class BinaryTree1 {

    /**
     * 反转二叉树
     * https://leetcode.cn/problems/invert-binary-tree/description/
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }

    /**
     * 链接二叉树
     * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        trav(root.left, root.right);
        return root;
    }

    private void trav(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        a.next = b;
        trav(a.left, a.right);
        trav(a.right, b.left);
        trav(b.left, b.right);
    }

    /**
     * 展开二叉树为链表
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;

        root.left = null;
        root.right = leftTree;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightTree;
    }


}
