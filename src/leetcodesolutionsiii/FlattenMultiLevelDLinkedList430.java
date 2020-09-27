
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class FlattenMultiLevelDLinkedList430
{
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node create()
    {
        return new Node();
    }
    public Node flatten(Node head) 
    {
        if(head == null)
        {
            return null;
        }
        
        Node curr = head;
        
        while(curr != null)
        {
            if(curr.child != null)
            {
                Node nexttemp = curr.next;
                Node temp = flatten(curr.child);
                curr.next = temp;
                temp.prev = curr;
                curr.child = null;
                while(curr.next != null)
                {
                    curr = curr.next;
                    
                }
                curr.next = nexttemp;
                if(nexttemp != null)
                {
                    nexttemp.prev = curr;
                }
                
                //curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}
