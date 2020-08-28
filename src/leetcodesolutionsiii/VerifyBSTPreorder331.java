
package leetcodesolutionsiii;
import java.util.*;


public class VerifyBSTPreorder331
{
    int pointer = 0;
    public boolean isValidSerialization(String preorder) 
    {
        pointer = 0;
        if(preorder.trim().isEmpty())
        {
            return true;
        }
        String[] preorderSplit = preorder.split(",");
        if(preorderSplit.length == 0)
        {
            return false;
        }
        if(preorderSplit[0] == "#")
        {
            return true;
        }
        
        boolean token = isValidHelper(preorderSplit, new Stack<>());
        if(pointer < preorderSplit.length)
        {
            return false;
        }
        return token;
    }
    private boolean isValidHelper(String[] preorder, Stack<String> st)
    {
        if(pointer > preorder.length)
        {
            return false;
        }
        if(preorder[pointer].equals("#"))
        {
            pointer++;
            return true;
        }
        
        st.push(preorder[pointer]);
        pointer++;
        
        boolean token = isValidHelper(preorder, st);
        if(!token)
            return false;
        token = isValidHelper(preorder, st);
        if(!token)
            return false;
        st.pop();
            
        return true;
    }
}
