
package leetcodesolutionsiii;

    public class BinTreeLongestConsecutiveSeqII549
    {
        int maxlen = 0;
        public int longestConsecutive(TreeNode root) 
        {
            if(root == null)
                return 0;
            maxlen = 0;
            int[] solution = traverse(root);
            int max = solution[0] < solution[1] ? solution[1] : solution[0];
            maxlen = maxlen < max ? max : maxlen;
            return maxlen;

        }
        public int[] traverse(TreeNode root)
        {
            if(root.right == null && root.left == null)
            {
                return new int[]{1,1};
            }

            int[] left = new int[]{0,0};
            int[] right = new int[]{0,0};

            if(root.left != null)
            {
                left = traverse(root.left);
            }
            if(root.right != null)
            {
                right = traverse(root.right);
            }

            int[] solution = new int[]{1 , 1};
            if(root.left != null && root.val == root.left.val - 1)
            {
                int res = left[0] + 1;
                solution[0] = solution[0] < res ? res : solution[0];
            }
            else if(root.left != null && root.val == root.left.val + 1)
            {
                int res = left[1] + 1;
                solution[1] = solution[1] < res ? res : solution[1];
            }

            if(root.right != null &&root.val == root.right.val - 1)
            {
                int res = right[0] + 1;
                solution[0] = solution[0] < res ? res : solution[0];
            }
            else if(root.right != null && root.val == root.right.val + 1)
            {
                int res = right[1] + 1;
                solution[1] = solution[1] < res ? res : solution[1];
            }
            int max = solution[0] < solution[1] ? solution[1] : solution[0];
            maxlen = maxlen < max ? max : maxlen;

            if(root.left != null && root.right != null)
            {
                if(root.val == root.left.val - 1 && root.val == root.right.val + 1)
                {
                    max = left[0] + right[1] + 1;
                    maxlen = maxlen < max ? max : maxlen;
                }
                else if(root.val == root.left.val + 1 && root.val == root.right.val - 1)
                {
                    max = left[1] + right[0] + 1;
                    maxlen = maxlen < max ? max : maxlen;
                }
            }

            return solution;
        }
    }
