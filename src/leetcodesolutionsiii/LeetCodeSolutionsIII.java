
package leetcodesolutionsiii;
import java.util.*;
public class LeetCodeSolutionsIII
{

    public static void main(String[] args)
    {
        FlattenMultiLevelDLinkedList430 ob = new FlattenMultiLevelDLinkedList430();
        FlattenMultiLevelDLinkedList430.Node head = ob.create();
        
        head.val = 1;
        head.next = ob.create();
        head.next.prev = head;
        head.next.val = 2;
        head.next.next = ob.create();
        head.next.next.val = 3;
        head.next.next.prev = head.next;
        FlattenMultiLevelDLinkedList430.Node three = head.next.next;
        three.child = ob.create();
        three.child.val = 7;
        FlattenMultiLevelDLinkedList430.Node seven = three.child;
        seven.next = ob.create();
        seven.next.val = 8;
        seven.next.prev = seven;
        FlattenMultiLevelDLinkedList430.Node eight = seven.next;
        eight.next = ob.create();
        eight.next.val = 9;
        eight.next.prev = eight;
        eight.child = ob.create();
        eight.child.val = 10;
        FlattenMultiLevelDLinkedList430.Node ten = eight.child;
        ten.next = ob.create();
        ten.next.val = 11;
        ten.next.prev = ten;
        three.next = ob.create();
        three.next.val = 4;
        three.next.prev = three;
        FlattenMultiLevelDLinkedList430.Node four = three.next;
        four.next = ob.create();
        four.next.val = 5;
        four.next.prev = four;
        four.next.next = ob.create();
        four.next.next.val = 6;
        four.next.next.prev = four.next;
        FlattenMultiLevelDLinkedList430.Node o = (new FlattenMultiLevelDLinkedList430()).flatten(head);
    }
    
}
