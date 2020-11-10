
package leetcodesolutionsiii;


public class MaximumBinaryTree654
{
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        return helperConstructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    private TreeNode helperConstructMaximumBinaryTree(int[] nums, int left, int right)
    {
        if(left > right)
        {
            return null;
        }
        if(left == right)
        {
            return new TreeNode(nums[left]);
        }
        int max = left;
        for(int i = left; i <= right; ++i)
        {
            if(nums[i] > nums[max])
            {
                max = i;
            }
        }
        TreeNode tn = new TreeNode(nums[max]);
        tn.left = helperConstructMaximumBinaryTree(nums, left, max - 1);
        tn.right = helperConstructMaximumBinaryTree(nums, max + 1, right);
        return tn;
    }
}
