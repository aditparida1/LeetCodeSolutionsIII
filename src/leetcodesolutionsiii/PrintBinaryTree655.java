
package leetcodesolutionsiii;
import java.util.*;

public class PrintBinaryTree655
{
    public List<List<String>> printTree(TreeNode root) 
    {
        List<List<String>> fls = new ArrayList<>();
        if(root == null)
        {
            return fls;
        }
        int height = heightOfTree(root);
        int numOfLeaves = (int)Math.pow(2, height - 1);
        int toFill = numOfLeaves + numOfLeaves - 1;
        for (int i = 0; i < height; i++)
        {
            List<String> ls = new ArrayList<>();
            for (int j = 0; j < toFill; j++)
            {
                ls.add("");
            }
            fls.add(ls);
        }
        fill(fls, 0, toFill - 1, 0, root);
        return fls;
    }
    private int heightOfTree(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        
        return right < left ? left + 1 : right + 1;
    }
    private void fill(List<List<String>> fls, int left, int right, int level, TreeNode root)
    {
        if(root == null)
            return;
        String val = Integer.toString(root.val);
        
        int mid = (left + right) / 2;
        fls.get(level).set(mid, val);
        
        fill(fls, left, mid - 1, level + 1, root.left);
        fill(fls, mid + 1, right, level + 1, root.right);
    }
}
