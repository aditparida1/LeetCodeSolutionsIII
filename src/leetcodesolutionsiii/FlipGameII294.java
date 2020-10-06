
package leetcodesolutionsiii;
import java.util.*;

public class FlipGameII294
{
    public boolean canWin(String s) 
    {
        char[] state = s.toCharArray();
        
        return flipGameII(state, new HashMap<>());
    }
    public boolean flipGameII(char[] currState, HashMap<String, Boolean> map)
    {
        String st = new String(currState);
        if(map.containsKey(st))
        {
            return map.get(st);
        }
        for (int i = 0; i < currState.length - 1; i++)
        {
            if(currState[i] == '+' && currState[i + 1] == '+')
            {
                currState[i] = '-';
                currState[i + 1] = '-';;
                if(!flipGameII(currState, map))
                {
                    currState[i] = '+';
                    currState[i+1] = '+';
                    //String state = new String(currState);
                    map.put(st, true);
                    return true;
                }
                currState[i] = '+';
                currState[i + 1] = '+';;
            }
        }
        map.put(st, false);
        return false;
    }
}
