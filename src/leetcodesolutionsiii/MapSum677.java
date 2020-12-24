
package leetcodesolutionsiii;
import java.util.*;

public class MapSum677
{
    HashMap<String, Integer> map = new HashMap<>();
    Trie wordMap = new Trie();
    public MapSum677() 
    {
        
    }
    
    public void insert(String key, int val) 
    {
        map.put(key, val);
        wordMap.insert(key);
    }
    
    public int sum(String prefix) 
    {
        int sum = 0;
        List<String> ls = wordMap.search(prefix);
        for(String ip: ls)
        {
            sum += map.get(ip);
        }
        return sum;
    }
    
}
class Trie
{
    HashMap<Character, Trie> map = new HashMap<>();
    
    public void insert(String input)
    {
        Trie currNode = this;
        for (int i = 0; i < input.length(); i++)
        {
            if(currNode.map.containsKey(input.charAt(i)))
            {
                currNode = currNode.map.get(input.charAt(i));
            }
            else
            {
                currNode.map.put(input.charAt(i), new Trie());
                currNode = currNode.map.get(input.charAt(i));
            }
        }
        currNode.map.put('\0', null);
    }
    
    public List<String> search(String input)
    {
        List<String> ls = new ArrayList<>();
        Trie currNode = this;
        for (int i = 0; i < input.length(); i++)
        {
            if(currNode.map.containsKey(input.charAt(i)))
            {
                currNode = currNode.map.get(input.charAt(i));
            }
            else
            {
                return ls;
            }
        }
        buildWords(currNode, ls, new StringBuilder(input));
        
        return ls;
    }
    public void buildWords(Trie node, List<String> ls, StringBuilder sb)
    {
        for(char currChar: node.map.keySet())
        {
            if(currChar == '\0')
            {
                ls.add(sb.toString());
            }
            else
            {
                sb.append(currChar);
                buildWords(node.map.get(currChar), ls, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}