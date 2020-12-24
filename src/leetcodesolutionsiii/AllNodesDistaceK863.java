
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class AllNodesDistaceK863
{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) 
    {
        HashMap<TreeNode, List<TreeNode>> graph = getGraph(root);
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int step = 0;
        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                size--;
                TreeNode node = q.poll();
                List<TreeNode> ls = graph.get(node);
                for(TreeNode child: ls)
                {
                    if(!set.contains(child))
                    q.add(child);
                    set.add(child);
                }
                if(step == K)
                {
                    result.add(node.val);
                }
            }
            if(step == K)
            {
                break;
            }
            step++;
        }
        return result;
    }
    private HashMap<TreeNode, List<TreeNode>> getGraph(TreeNode root)
    {
        Queue<TreeNode> pq = new LinkedList<>();
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        pq.add(root);
        while(!pq.isEmpty())
        {
            TreeNode curr = pq.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if(!map.containsKey(curr))
            {
                map.put(curr, new ArrayList<TreeNode>());
            }
            if(left != null)
            {
                map.get(curr).add(left);
                if(!map.containsKey(left))
                {
                    map.put(left, new ArrayList<>());
                }
                map.get(left).add(curr);
                pq.add(left);
            }
            if(right != null)
            {
                map.get(curr).add(right);
                if(!map.containsKey(right))
                {
                    map.put(right, new ArrayList<>());
                }
                map.get(right).add(curr);
                pq.add(right);
            }
            
        }
        return map;
    }
}
