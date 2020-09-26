
package leetcodesolutionsiii;

/**
 *
 * @author aditp
 */
public class BSTToSortedDoubLinkedList426
{
    class Node
    {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
    }
    }
    public Node treeToDoublyList(Node root) 
    {
        Node[] list = inOrder(root);
        if(list == null)
        {
            return null;
        }
        list[1].right = list[0];
        list[0].left = list[1];
        
        return list[0];
    }
    private Node[] inOrder(Node root)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            Node[] left = inOrder(root.left);
            Node[] right = inOrder(root.right);
            Node[] temp = new Node[2];
            if(left != null)
            {
                left[1].right = root;
                root.left = left[1];
                temp[0] = left[0];
            }
            else
            {
                temp[0] = root;
            }
            if(right != null)
            {
                right[0].left = root;
                root.right = right[0];
                temp[1] = right[1];
            }
            else
            {
                temp[1] = root;
            }
            //Node[] temp = new Node[]{left[0], right[1]};
            return temp;
            
        }
        //return null;
    }
}
