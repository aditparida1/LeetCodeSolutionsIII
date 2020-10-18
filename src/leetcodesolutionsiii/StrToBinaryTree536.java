/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

/**
 *
 * @author aditp
 */
public class StrToBinaryTree536
{
    public TreeNode str2tree(String s) 
    {
        
        if(s == null || s.length() == 0 || s.trim().length() == 0)
        {
            return null;
        }
        int i;
        for (i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                break;
        }
        int number = Integer.parseInt(s.substring(0, i));
        int count = 1;
        int end = i + 1;
        while(end < s.length() && count != 0)
        {
            if(s.charAt(end) == '(')
                count++;
            else if(s.charAt(end) == ')')
                count--;
            end++;
        }
        String left = null;
        if(i+1 < end - 1) left = s.substring(i+1, end - 1);
        i = end;
        while(end < s.length())
        {
            if(s.charAt(end) == '(')
                count++;
            else if(s.charAt(end) == ')')
                count--;
            end++;
            if(count == 0)
                break;
            
        }
        String right = null;
        if(i + 1 < end - 1) right = s.substring(i + 1, end - 1);
        
        TreeNode root = new TreeNode(number);
        root.left = str2tree(left);
        root.right = str2tree(right);
        
        return root;
    }
}
