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
public class FindLeavesofBinTree366
{
    public List<List<Integer>> findLeaves(TreeNode root) 
    {
        if(root == null)
        {
            return new ArrayList<>();
        }
        int height = height(root);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < height; i++)
        {
            ls.add(new ArrayList<>());
        }
        augmentedTraverse(root, ls);
        return ls;
    }
    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return left < right ? right + 1 : left + 1;
    }
    public int augmentedTraverse(TreeNode root, List<List<Integer>> list)
    {
        if(root == null)
        {
            return 0;
        }
        int left = augmentedTraverse(root.left, list);
        int right = augmentedTraverse(root.right, list);
        int curr = left < right ? right + 1: left + 1;
        list.get(curr - 1).add(root.val);
        return curr;
    }
}
