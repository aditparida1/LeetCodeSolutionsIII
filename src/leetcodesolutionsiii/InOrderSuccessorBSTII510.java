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
public class InOrderSuccessorBSTII510
{
    public Node inorderSuccessor(Node node) 
    {
        
        if(node == null)
        {
            return null;
        }
        if(node.right == null && node.parent == null)
        {
            return null;
        }
        
        if(node.right != null)
        {
            Node temp = node.right;
            while(temp.left != null)
            {
                temp = temp.left;
            }
            return temp;
        }
        Node par = node.parent;
        
        while(par != null && par.left != node)
        {
            node = par;
            par = par.parent;
        }
        
        return par;        
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};