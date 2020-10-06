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
public class ValidateIP468
{
    public String validIPAddress(String ip) 
    {
        if(ip.length() < 7)
        {
            return "Neither";
        }
        if(ip.indexOf(".") != -1)
        {
            if(ip.length() > 15)
            {
                return "Neither";
            }
            int count = 0;
            for (int i = 0; i < ip.length(); i++)
            {
                if(ip.charAt(i ) == '.')
                    count++;
            }
            if(count > 3)
            {
                return "Neither";
            }
            String[] split = ip.split("\\.");
            if(split.length != 4)
            {
                return "Neither";
            }
            for (int i = 0; i < split.length; i++)
            {
                int num = -1;
                try
                {
                    num = Integer.parseInt(split[i]);
                }
                catch (Exception ex)
                {
                    return "Neither";
                }
                if(num >= 256)
                {
                    return "Neither";
                }
                if(num < 0)
                {
                    return "Neither";
                }
                if(split[i].charAt(0) == '0')
                {
                    if(split[i].length()> 1)
                    {
                        return "Neither";
                    }
                }
            }
            return "IPv4";
        }
        if(ip.indexOf(":") != -1)
        {
            if(ip.length() > 39)
            {
                return "Neither";
            }
            int count = 0;
            for (int i = 0; i < ip.length(); i++)
            {
                if(ip.charAt(i ) == ':')
                    count++;
            }
            if(count > 7)
            {
                return "Neither";
            }
            String[] split = ip.split(":");
            if(split.length != 8)
            {
                return "Neither";
            }
            for (int i = 0; i < split.length; i++)
            {
                if(split[i].length() > 4)
                {
                    return "Neither";
                }
                int hex = -1;
                try
                {
                    hex = Integer.parseInt(split[i], 16);
                }
                catch(Exception ex)
                {
                    return "Neither";
                }
                if(hex < 0 || hex > 65535)
                {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}
