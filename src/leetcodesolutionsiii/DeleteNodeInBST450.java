
package leetcodesolutionsiii;
import java.util.*;

public class DeleteNodeInBST450
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root == null)
        {
            return root;
        }
        if(root.val == key)
        {
            return deleteNode(root);
        }
        else
        {
            TreeNode parentNode = SearchParentNode(root, key);
            if(parentNode == null)
            {
                return root;
            }
            if(parentNode.left != null && parentNode.left.val == key)
            {
                parentNode.left = deleteNode(parentNode.left);
            }
            else
            {
                parentNode.right = deleteNode(parentNode.right);
            }
            
        }
        return root;
    }
    public TreeNode SearchParentNode(TreeNode root, int key)
    {
        if(root == null)
        {
            return null;
        }
        if(root.left != null && root.left.val == key)
        {
            return root;
        }
        else if(root.right != null && root.right.val == key)
        {
            return root;
        }
        TreeNode tnLeft = null;
        TreeNode tnRight = null;
        if(key < root.val)
        {
            tnLeft = SearchParentNode(root.left, key);
        }
        else
        {
            tnRight = SearchParentNode(root.right, key);
        }
        if(tnLeft != null)
        {
            return tnLeft;
        }
        if(tnRight != null)
        {
            return tnRight;
        }
        return null;
    }
    public TreeNode deleteNode(TreeNode root)
    {
        TreeNode pred = predecessorDelete(root.left);
        if(pred == null)
        {
            return root.right;
        }
        else if(pred == root.left)
        {
            pred.right = root.right;
            return pred;
        }
        else
        {
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }
    }
    public TreeNode predecessorDelete(TreeNode root)
    {
        Stack<TreeNode> tn = new Stack<>();
        while(root != null)
        {
            tn.push(root);
            root = root.right;
        }
        if(tn.isEmpty())
        {
            return null;
        }
        if(tn.size() == 1)
        {
            return tn.pop();
        }
        TreeNode toDelete = tn.pop();
        TreeNode parent = tn.pop();
        parent.right = toDelete.left;
        return toDelete;
    }
}
