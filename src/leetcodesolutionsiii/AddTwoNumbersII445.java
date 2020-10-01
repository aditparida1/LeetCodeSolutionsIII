/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class AddTwoNumbersII445
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int currSum = 0;
        int carry = 0;
        
        Stack<ListNode> stSm = new Stack<>();
        Stack<ListNode> stLg = new Stack<>();
        
        while(l1 != null)
        {
            stSm.push(l1);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            stLg.push(l2);
            l2 = l2.next;
        }
        
        if(stSm.size() > stLg.size())
        {
            Stack<ListNode> stTemp = stSm;
            stSm = stLg;
            stLg = stTemp;
        }
        Stack<ListNode> resStack = new Stack<>();
        while(!stLg.isEmpty())
        {
            ListNode currNode = stLg.pop();
            int firVal = currNode.val;
            int secVal = 0;
            if(!stSm.isEmpty())
            {
                secVal = stSm.pop().val;
            }
            currSum = carry + firVal + secVal;
            if(currSum >= 10)
            {
                currSum = currSum % 10;
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            ListNode temp = new ListNode(currSum);
            if(!resStack.isEmpty())
            {
                temp.next = resStack.peek();
            }
            resStack.push(temp);
        }
        if(carry == 0)
        {
            ListNode temp = new ListNode(carry);
            if(!resStack.isEmpty())
            {
                temp.next = resStack.peek();
            }
            resStack.push(temp);
        }
        return resStack.peek();
    }
    
}
