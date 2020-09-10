
package leetcodesolutionsiii;
import java.util.*;

public class LongestAbsPath388
{
    public int lengthLongestPath(String input) 
    {
        Stack<String> st = new Stack<>();
        String[] tokens = input.split("\\n");
        int maxLen = 0;
        int len = 0;
        int deepest = 1;
        
        
        
        for (int i = 0; i < tokens.length; i++)
        {
            String currTok = tokens[i];
            int count = currTok.lastIndexOf("\t");
            count++;
            while(st.size() != count)
            {
                String poped = st.pop();
                len -= poped.length();
                len--;
            }
            st.push(currTok.substring(count));
            len += currTok.length() - count;
            len++;
            deepest = deepest < st.size() ? st.size() : deepest;
            if(currTok.lastIndexOf(".") != -1)
            {
                maxLen = len - 1 > maxLen ? len - 1 : maxLen;
                
            }
        }
        
        return maxLen;
    }
}
