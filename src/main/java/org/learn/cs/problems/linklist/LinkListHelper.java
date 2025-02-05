/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.linklist;

public class LinkListHelper {

    /**
     * 生成无环单链表
     *
     * @param nums
     * @return
     */
    public static ListNode buildList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 顺序打印链表的值
     *
     * @param head
     * @return
     */
    public static String printList(ListNode head) {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 比较两个链表是否相等
     *
     * @param l1
     * @param l2
     * @return
     */
    public static boolean compareList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode afterReverse = reverseList(head.next);
        afterReverse.next = head;
        head.next = null;
        return afterReverse;
    }
}
