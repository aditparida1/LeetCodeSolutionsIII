
package leetcodesolutionsiii;


import java.util.*;



public class GeneralizedAbbr320
{
    public List<String> generateAbbreviations(String word) 
    {
        if(word == null || word.trim().isEmpty())
        {
            return new ArrayList<String>();
        }
        List<String> ls = new ArrayList<String>();
        helperGenerate(word, 0, new Stack<String>(), ls);
        return ls;        
    }
    void helperGenerate(String word, int currPoint, Stack<String> st, List<String> ls)
    {
        if(currPoint >= word.length())
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.size(); i++)
            {
                sb.append(st.elementAt(i));
            }            
            //sb = sb.reverse();
            ls.add(sb.toString());
            
            return;
        }
        int remainingLen = word.length() - currPoint;
        for (int i = 0; i <= remainingLen; i++)
        {
            if(i == 0)
            {
                st.push(word.substring(currPoint, currPoint + 1));
                helperGenerate(word, currPoint + 1, st, ls);
                st.pop();
            }
            else
            {
                
                if(!st.isEmpty() && isNumeric(st.peek()))
                {
//                    st.push(word.substring(currPoint, currPoint + 1));
//                    helperGenerate(word, currPoint + 1, st, ls);
//                    st.pop();
                }
                else
                {
                    st.push(Integer.toString(i));
                
                    helperGenerate(word, currPoint + i, st, ls);

                    st.pop();
                }
                
            }
            
        }
    }
    boolean isNumeric(String num)
    {
        if(num == null)
        {
            return false;
        }
        try
        {
            int a = Integer.parseInt(num);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
        //return false;
        
    }
}
