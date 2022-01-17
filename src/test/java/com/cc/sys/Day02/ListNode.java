package com.cc.sys.Day02;

/**
 * @Author: cc
 * @Date: 2021/11/2 5:00 下午
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static class Solution {


        public static void deleteNode2(ListNode node) {
            ListNode next = node.next;
            node.next = next.next;
            node.val = next.val;
        }

        public static void deleteNode(ListNode node) {
            int val = node.val;
            while (node != null) {
                // 不能删除尾部节点
                if (node.next == null) {
                    System.out.println("不能删除尾部节点");
                    break;
                }
                if (node == null) {
                    System.out.println("到达尾部节点了");
                    break;
                }
                if(val == node.val) {
                    node = node.next;
                }
                System.out.println(node.val);
                node = node.next;
            }
            System.out.println(node);
        }


        public static void main(String[] args) {
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(2);
            ListNode listNode3 = new ListNode(3);
            ListNode listNode4 = new ListNode(4);
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode4;

            deleteNode(listNode1);
        }
    }

}
