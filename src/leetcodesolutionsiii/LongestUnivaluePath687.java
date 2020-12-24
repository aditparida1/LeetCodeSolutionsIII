
package leetcodesolutionsiii;
import java.util.*;

public class LongestUnivaluePath687
{
    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) 
    {
        maxLength = 0;
        if(root == null)
            return maxLength;
        
        updateMaxLength(root);
        return maxLength - 1;
    }
    public int updateMaxLength(TreeNode node)
    {
        
        if(node == null)
            return 0;
        //int res = 1;
        int left = updateMaxLength(node.left);
        int right = updateMaxLength(node.right);
        int total = 1;
        if(node.left != null)
        {
            if(node.left.val == node.val)
            {
                total += left;
            }
        }
        if(node.right != null)
        {
            if(node.right.val == node.val)
            {
                total += right;
            }
        }
        maxLength = Math.max(total, maxLength);
        int resWithLeft = 1;
        int resWithRight = 1;
        if(node.left != null)
        {
            if(node.left.val == node.val)
            {
                resWithLeft += left;
            }
        }
        if(node.right != null)
        {
            if(node.right.val == node.val)
            {
                resWithRight += right;
            }
        }
        return Math.max(resWithLeft, resWithRight);
    }
}
