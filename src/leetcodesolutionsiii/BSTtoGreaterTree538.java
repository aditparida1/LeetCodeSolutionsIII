
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class BSTtoGreaterTree538
{
    public TreeNode convertBST(TreeNode root) 
    {
        traverseSubTree(root, 0);
        return root;
    }
    private int traverseSubTree(TreeNode root, int val)
    {
        if(root == null)
        {
            return 0;
        }
        int temp = root.val;
        int n = traverseSubTree(root.right, val);
        root.val += n + val;
        int m = traverseSubTree(root.left, root.val);
        return temp + m + n;
    }
}
