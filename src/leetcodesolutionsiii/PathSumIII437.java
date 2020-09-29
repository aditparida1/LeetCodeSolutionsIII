
package leetcodesolutionsiii;
import java.util.*;

public class PathSumIII437
{
    int count;
    public int pathSum(TreeNode root, int sum) 
    {
        if(root == null)
            return 0;
        count = 0;
        traverse(root, new HashMap<>(), sum, 0);
        return count;        
    }
    public void traverse(TreeNode root, HashMap<Integer, Integer> hm, int target, int currSum)
    {
        if(root == null)
            return;
        currSum += root.val;
        //check for sub array ending at this point
        int remSum = currSum - target;
        if(hm.containsKey(remSum))
        {
            int freq = hm.get(remSum);
            count += freq;
        }
        if(currSum == target)
        {
            count++;
        }
        if(!hm.containsKey(currSum))
        {
            hm.put(currSum, 1);
        }
        else
        {
            hm.put(currSum, hm.get(currSum) + 1);
        }
        
        traverse(root.left, hm, target, currSum);
        traverse(root.right, hm, target, currSum);
        
        hm.put(currSum, hm.get(currSum) - 1);
        if(hm.get(currSum) == 0)
        {
            hm.remove(currSum);
        }
    }
}
