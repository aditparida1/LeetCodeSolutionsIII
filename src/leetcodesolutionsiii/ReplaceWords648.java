
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class ReplaceWords648
{
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        if(dictionary == null || dictionary.size() == 0)
        {
            return sentence;
        }
        Trie root = new Trie();
        for(String s : dictionary)
        {
            root.insertString(s);
        }
        
        String[] split = sentence.split(" ");
        String[] solution = new String[split.length];
        
        for (int i = 0; i < split.length; i++)
        {
            int len = root.search(split[i]);
            if(len != -1)
            {
                split[i] = split[i].substring(0,len);
            }
        }
        StringBuilder res =  new StringBuilder();
        res.append(split[0]);
        for (int i = 1; i < split.length; i++)
        {
            res.append(" ");
            res.append(split[i]);
        }
        return res.toString();
    }
}
class Trie
{
    //char c;
    HashMap<Character, Trie> map;
    public Trie()
    {
        //this.c = c;
        map = new HashMap<>();
    }
    public void insertString(String input)
    {
        Trie current = this;
        for (int i = 0; i < input.length(); i++)
        {
            if(current.map.containsKey(input.charAt(i)))
            {
                current = current.map.get(input.charAt(i));
            }
            else
            {
                current.map.put(input.charAt(i), new Trie());
                current = current.map.get(input.charAt(i));
            }
        }
        current.map.put('\0', null);
    }
    public int search(String input)
    {
        Trie current = this;
        int count = 0;
        for (int i = 0; i < input.length(); i++)
        {
            if(!current.map.containsKey(input.charAt(i)))
            {
                break;
            }
            else if(current.map.containsKey('\0'))
            {
                return count;
            }
            else
            {
                current = current.map.get(input.charAt(i));
                count++;
            }
        }
        if(!current.map.containsKey('\0'))
        {
            return -1;
        }
        return count;
    }
}
