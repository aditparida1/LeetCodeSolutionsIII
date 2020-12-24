
package leetcodesolutionsiii;
import java.util.*;


public class MagicDictionary676 
{
    Trie wordMap;
    public MagicDictionary676() 
    {
        wordMap = new Trie();
    }
    
    public void buildDict(String[] dictionary) 
    {
        for (int i = 0; i < dictionary.length; i++)
        {
            wordMap.insert(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) 
    {
        char[] ip = searchWord.toCharArray();
        for (int i = 0; i < ip.length; i++)
        {
            for (int j = 'a'; j <= 'z'; j++)
            {
                if(ip[i] != j)
                {
                    char currChar = ip[i];
                    ip[i] = (char)j;
                    if(wordMap.search(ip))
                    {
                        return true;
                    }
                    ip[i] = currChar;
                }
            }
        }
        
        return false;
    }
}

class Trie
{
    HashMap<Character, Trie> map = new HashMap<>();
    public void insert(String input)
    {
        char[] ip = input.toCharArray();
        Trie currNode = this;
        for (int i = 0; i < ip.length; i++)
        {
            //char currChar = ip[i];
            if(currNode.map.containsKey(ip[i]))
            {
                currNode = currNode.map.get(ip[i]);
            }
            else
            {
                currNode.map.put(ip[i], new Trie());
                currNode = currNode.map.get(ip[i]);
            }
        }
        currNode.map.put('\0', null);
    }
    public boolean search(char[] input)
    {
        Trie currNode = this;
        for(int i = 0; i < input.length; ++i)
        {
            if(!currNode.map.containsKey(input[i]))
            {
                return false;
            }
            else
            {
                currNode = currNode.map.get(input[i]);
            }
        }
        if(!currNode.map.containsKey('\0'))
        {
            return false;
        }
        return true;
    }
}