/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;
import java.util.*;
/**
 *
 * @author aditp
 */
public class DecodeString394
{
    
    public String decodeString(String s) 
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length())
        {
            char currChar = s.charAt(i);
            if(!isDigit(currChar))
            {
                sb.append(Character.toString(currChar));
                i++;
            }
            else
            {
                
                int j = i;
                while(j < s.length() && isDigit(s.charAt(j)))
                {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                String tobeAdded;
                i = j;
                if(s.charAt(j) == '[')
                {
                    int count = 1;
                    //count
                    j+=1;
                    while(j < s.length() && count != 0)
                    {
                        if(s.charAt(j) == '[')
                        {
                            count++;
                        }
                        else if(s.charAt(j) == ']')
                        {
                            count--;
                        }
                        j++;
                    }
                }
                tobeAdded = decodeString(s.substring(i + 1, j - 1));
                while(num > 0)
                {
                    sb.append(tobeAdded);
                    num--;
                }
                i = j;
            }
            
        }
        return sb.toString();        
    }
    
    boolean isDigit(char c)
    {
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
}
