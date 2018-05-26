package io.github.gzhennaxia;

/**
 * @Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @Author: LiBo
 * @Date: 2018/5/26下午 03:51
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;
        ListNode ret = addTwoNumbers(l1, l2);
        System.out.println("ret = " + ret);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);

        //循环变量
        ListNode ln = ret;

        //进位
        int carry = 0;

        while (l1 != null || l2 != null) {
            //把单节点与双节点的操作统一起来
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            ln.next = new ListNode(sum % 10);
            ln = ln.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //最高位的进位要特殊处理
        if (carry == 1) {
            ln.next = new ListNode(1);
        }
        return ret.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode ln = this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (ln != null) {
            if (ln.next == null) {
                stringBuilder.append(ln.val + "]");
            } else {
                stringBuilder.append(ln.val + ",");
            }
            ln = ln.next;
        }
        return stringBuilder.toString();
    }
}