
package leetcodesolutionsiii;


public class IsSubseq392
{
    public boolean isSubsequence(String t, String s) 
    {
        if(s.trim().isEmpty() && !t.trim().isEmpty())
        {
            return false;
        }
        if(s.trim().isEmpty() && t.trim().isEmpty())
        {
            return true;
        }
        
        int pointer = 0;
        for (int i = 0; i < t.length(); i++)
        {
            if(pointer >= s.length())
            {
                return false;
            }
            char check = t.charAt(i);
            boolean found = false;
            for (; pointer < s.length(); pointer++)
            {
                if(s.charAt(pointer) == check)
                {
                    pointer++;
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                return false;
            }
        }
        return true;
    }
}
