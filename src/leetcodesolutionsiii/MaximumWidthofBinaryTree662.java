
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class MaximumWidthofBinaryTree662
{
    HashMap<Integer, int[]> map;
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root == null)
            return 0;
        map = new HashMap<>();
        int height = height(root);
        for(int i = 1; i <= height; ++i)
        {
            map.put(i, new int[]{-1,-1});
        }
        updateMapwithFirstLastofLevel(root, 1, 1);
        int max = -1;
        for(int key: map.keySet())
        {
            int[] range = map.get(key);
            int width = 1;
            if(range[1] != -1)
            {
                width = range[1] - range[0] + 1;
            }
            max = Math.max(max, width);
        }
        return max;
    }
    private int height(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return left > right ? left + 1: right + 1;
    }
    private void updateMapwithFirstLastofLevel(TreeNode root, int position, int level)
    {
        int[] range = map.get(level);
        if(range[0] == -1)
        {
            range[0] = position;
        }
        else
        {
            if(range[1] == -1)
            {
                range[1] = position;
            }
            else if(range[1] < position)
            {
                range[1] = position;
            }
        }
        int left = position * 2 - 1;
        int right = position * 2;
        if(root.left != null)
        {
            updateMapwithFirstLastofLevel(root.left, left, level + 1);
        }
        if(root.right != null)
        {
            updateMapwithFirstLastofLevel(root.right, right, level + 1);
        }
    }
}
