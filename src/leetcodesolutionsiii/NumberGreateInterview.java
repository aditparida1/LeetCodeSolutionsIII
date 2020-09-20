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
public class NumberGreateInterview
{
    public int solution(int ip)
    {
        String input = Integer.toString(ip);
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(char c = input.charAt(0); c >= '1'; --c)
        {
            boolean b = create(input, 1, (char)(c+1), st);
            if(b)
            {
                while(!st.isEmpty())
                {
                    sb.append(st.pop());
                }
                return Integer.parseInt(sb.reverse().toString());
            }
        }
        
        return 0;
    }
    public String createDummy(int size)
    {
        StringBuilder sb = new StringBuilder();
        //char ini = 10 - size;
        return "";
    }
    public boolean create(String ip, int pos, char atLeast, Stack<Character> st)
    {
        if(pos > ip.length())
        {
            return true;
        }
        if(atLeast >'9')
        {
            return false;
        }
        if(atLeast > ip.charAt(pos))
        {
            return false;
        }
        
        for(char c = ip.charAt(pos); c >= atLeast; --c)
        {
            st.push(c);
            boolean b = create(ip, pos + 1, (char)(c + 1) , st);
            if(b)
            {
                return true;
            }
            st.pop();
        }
        return false;
    }
}
