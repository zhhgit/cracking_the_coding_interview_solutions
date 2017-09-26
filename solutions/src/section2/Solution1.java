package section2;

import common.*;

import java.util.HashMap;

/**
 * Created by zhanghao1 on 2017/9/26.
 * 移除链表中重复节点
 */
public class Solution1 {
    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,5,6};
        ListBuilder listBuilder = new ListBuilder();
        listBuilder.createList(nums);
        ListNode head = listBuilder.nodeList.get(0);
        deleteDups2(head);
        ListNode curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    //删除链表中重复的节点
    private static void deleteDups(ListNode head){
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        ListNode curr = head;
        if(head != null){
            hashMap.put(head.val,true);
        }
        while(curr != null && curr.next != null){
            int currNextVal = curr.next.val;
            if(!hashMap.containsKey(currNextVal)){
                hashMap.put(currNextVal,true);
            }
            else{
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }

    //删除链表中重复的节点
    private static void deleteDups2(ListNode head){
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            if(!hashMap.containsKey(curr.val)){
                hashMap.put(curr.val,true);
                prev = curr;
            }
            else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }
}
