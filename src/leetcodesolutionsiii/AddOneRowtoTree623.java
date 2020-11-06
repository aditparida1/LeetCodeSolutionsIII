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
public class AddOneRowtoTree623
{
    public TreeNode addOneRow(TreeNode root, int v, int d) 
    {
        if(d == 1)
        {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            root = temp;
            return root;
        }
        helperAddRow(root, v, 1, d);
        return root;    
    }
    
    private void helperAddRow(TreeNode root, int val, int currLevel, int reqLevel)
    {
        if(root == null)
        {
            return;
        }
        if(currLevel == reqLevel - 1)
        {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            
        }
        else
        {
            helperAddRow(root.left, val, currLevel + 1, reqLevel);
            helperAddRow(root.right, val, currLevel + 1, reqLevel);
        }
    }
}
