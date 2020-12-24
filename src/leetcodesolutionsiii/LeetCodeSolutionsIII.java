
package leetcodesolutionsiii;
import java.util.*;
public class LeetCodeSolutionsIII
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(new LongestUnivaluePath687().longestUnivaluePath(root));
    }
}