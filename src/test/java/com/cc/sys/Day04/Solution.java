package com.cc.sys.Day04;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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
class Solution {


    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l1_2 = new ListNode();
        ListNode l1_3 = new ListNode();
        l1.val = 2;
        l1_2.val = 3;
        l1_3.val = 3;
        l1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2 = new ListNode();
        ListNode l2_2 = new ListNode();
        ListNode l2_3 = new ListNode();
        l2.val = 5;
        l2_2.val = 6;
        l2_3.val = 2;
        l2.next = l2_2;
        l2_2.next = l2_3;

        addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    static ListNode listNode = new ListNode();

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int y = 0;
        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val;
//            if (i > 9) {
//                y = 1;
//            }
//            listNode.val = i;
//            if (y == 1) {
//                listNode.val = i + 1;
//                y = 0;
//            }
            listNode = addListNode(listNode, i);
            l1 = l1.next;
            l2 = l2.next;
        }
        return listNode;
    }

    public static ListNode addListNode(ListNode listNode, int val) {

        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(val);

        return listNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}

