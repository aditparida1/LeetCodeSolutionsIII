
package leetcodesolutionsiii;


public class OddEvenlinkedLIst328
{
    public ListNode oddEvenList(ListNode head) 
    {
        if( head == null || head.next == null || head.next.next == null)
        {
            return head;
        }
        ListNode main = head;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode currEven = head.next;
        ListNode currOdd = head;
        while(currEven != null && currOdd != null)
        {
            currOdd.next = currOdd.next.next;
            currOdd = currOdd.next;
            if(currEven.next != null)
            {
                currEven.next = currEven.next.next;
                currEven = currEven.next;
            }
        }
        if(currOdd != null)
        {
            currOdd.next = even;
        }
        else
        {
            currOdd = odd;
            while(currOdd.next != null)
            {
                currOdd = currOdd.next;
            }
            currOdd.next = even;
        }
        return odd;
    }
}
