
package leetcodesolutionsiii;
import java.util.*;

public class LargestBSTSubTree333
{
    int max = 1;
    public int largestBSTSubtree(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        max = 1;
        largestSubtreeBSTHelper(root);
        return max;
    }
    public void largestSubtreeBSTHelper(TreeNode root)
    {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        if(!check(inorder))
        {
            largestSubtreeBSTHelper(root.left);
            largestSubtreeBSTHelper(root.right);
        }
        else
        {
            max = inorder.size() > max ? inorder.size() : max;
        }
    }
    private boolean check(List<Integer> ls)
    {
        for (int i = 1; i < ls.size(); i++)
        {
            if(ls.get(i) <= ls.get(i - 1))
            {
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode root, List<Integer> ls)
    {
        if(root == null)
            return;
        inOrder(root.left, ls);
        ls.add(root.val);
        inOrder(root.right, ls);
    }
}
