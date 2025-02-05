/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.linklist;

import java.util.PriorityQueue;

class Solution {

    public int removeElement(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast <= nums.length - 1) {
            int fastVal = nums[fast];
            if (fastVal == target) {
                fast += 1;
            } else if (fastVal != target) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow += 1;
                fast += 1;
            }
        }
        return slow;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = 0;
        int sum = nums[0];
        int minLength = nums.length;
        while (fast <= nums.length - 1) {
            if (sum >= target) {
                int currentLength = fast - slow;
                if (currentLength <= minLength) {
                    minLength = currentLength;
                }
                sum = sum - nums[slow];
                slow += 1;
            } else {
                fast += 1;
                sum += nums[fast];
            }
        }
        return minLength;
    }

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][] {{n}};
        }

        int[][] res = new int[n][n];
        int row = 0, col = 0, circle = 1;
        int counter = 1;
        while (counter <= n * n) {
            while (col < n - circle) {
                res[row][col] = counter;
                counter += 1;
                col += 1;
            }
            while (row < n - circle) {
                res[row][col] = counter;
                counter += 1;
                row += 1;
            }
            while (col > circle - 1) {
                res[row][col] = counter;
                counter += 1;
                col -= 1;
            }
            while (row > circle - 1) {
                res[row][col] = counter;
                counter += 1;
                row -= 1;
            }
            col += 1;
            row += 1;
            circle += 1;
            if (counter == n * n && n % 2 == 1) {
                res[row][col] = counter;
                counter += 1;
            }
        }

        return res;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            p.next = tmp;
            p = p.next;
            if (tmp.next != null) {
                pq.add(tmp.next);
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode repeat = new ListNode(999);
        ListNode noRepeat = new ListNode(998);

        ListNode p = head;
        ListNode pRepeat = repeat;
        ListNode pNoRepeat = noRepeat;

        while (p != null && p.next != null) {
            if (p.val == p.next.val || p.val == pRepeat.val) {
                pRepeat.next = p;
                pRepeat = pRepeat.next;

            } else {
                pNoRepeat.next = p;
                pNoRepeat = pNoRepeat.next;
            }
            p = p.next;
            pNoRepeat.next = null;
            pRepeat.next = null;
        }
        return noRepeat.next;
    }

    /**
     * https://leetcode.cn/problems/ugly-number-ii/
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode afterReverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return afterReverse;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = head;
        for (int i = 0; i < left - 2; i++) {
            p = p.next;
        }
        p.next = reverseN(p.next, right - left + 1);
        return head;
    }

    /**
     * 反转n个节点
     */
    private ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode iN = head;
        for (int i = 0; i < n; i++) {
            if (iN == null) {
                return head;
            } else {
                iN = iN.next;
            }
        }
        ListNode dummy = new ListNode(-5001);
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n -= 1;
        }
        head.next = cur;
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // int counter = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode pre = null;
        while (p != null) {
            p.next = reverseN(head, k);
            pre = p;
            p = head;
            head = head.next;
            if (head == null) {
                break;
            }
            // counter += 1;
        }
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode rev = reverseWithNew(head);
        ListNode a = head;
        ListNode b = rev;
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return true;
    }

    private ListNode reverseWithNew(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = new ListNode(head.val);
        ListNode nxt = head.next;
        while (nxt != null) {
            cur.next = pre;
            pre = cur;
            cur = new ListNode(nxt.val);
            nxt = nxt.next;
        }
        cur.next = pre;
        pre = cur;
        return pre;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //        ListNode head = LinkListHelper.buildList(new int[] {1, 2, 2, 1});
        ListNode head = LinkListHelper.buildList(new int[] {1, 2, 3, 4});
        boolean a = solution.isPalindrome(head);

    }
}