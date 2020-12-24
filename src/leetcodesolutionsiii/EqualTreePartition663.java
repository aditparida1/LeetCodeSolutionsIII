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
public class EqualTreePartition663
{
    public boolean checkEqualTree(TreeNode root) 
    {
        SumTree sumTree = createSumTree(root);
        
        return isPossible(sumTree, 0) || isPossible(sumTree.right, sumTree.val + sumTree.leftSum);        
    }
    public SumTree createSumTree(TreeNode root)
    {
        if(root == null)
            return null;
        SumTree node = new SumTree(root.val);
        SumTree leftTree = createSumTree(root.left);
        SumTree rightTree = createSumTree(root.right);
        int leftSum = 0, rightSum = 0;
        if(leftTree != null)
        {
            leftSum += leftTree.leftSum + leftTree.rightSum + leftTree.val;
        }
        if(rightTree != null)
        {
            rightSum += rightTree.val + rightTree.rightSum + rightTree.leftSum;
        }
        node.leftSum = leftSum;
        node.rightSum = rightSum;
        node.left = leftTree;
        node.right = rightTree;
        return node;
    }

    private boolean isPossible(SumTree sumTree, int parentSum)
    {
        if(sumTree == null)
            return false;
        int currSum = sumTree.val + sumTree.leftSum + sumTree.rightSum;
        if(currSum == parentSum)
        {
            return true;
        }
        return isPossible(sumTree.left, parentSum + sumTree.rightSum + sumTree.val) || isPossible(sumTree.right, parentSum + sumTree.leftSum + sumTree.val);
    }
}
class SumTree
{
    int val;
    int leftSum;
    int rightSum;

    public SumTree(int val)
    {
        this.val = val;
    }
    
    SumTree left = null;
    SumTree right = null;
    
}