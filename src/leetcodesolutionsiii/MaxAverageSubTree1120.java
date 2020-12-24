
package leetcodesolutionsiii;
import java.util.*;


public class MaxAverageSubTree1120
{
    double maxAverage;
    public double maximumAverageSubtree(TreeNode root) 
    {
        maxAverage = 0;
        traverse(root);
        return maxAverage;
    }
    
    public int[] traverse(TreeNode node)
    {
        int[] result = {0, 0};
        if(node == null)
        {
            return result;
        }
        int[] leftResult = traverse(node.left);
        int[] rightResult = traverse(node.right);
        int total = leftResult[1] + node.val + rightResult[1];
        result[1] = total;
        result[0] = leftResult[0] + rightResult[0] + 1;
        double avg = result[1] / (double)result[0];
        maxAverage = Math.max(avg, maxAverage);
        return result;
    }
}
