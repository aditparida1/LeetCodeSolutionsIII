package leetcodesolutionsiii;
import java.util.*;

/**
 *
 * @author aditp
 */
public class SolvetheEquation640
{
    public String solveEquation(String equation) 
    {
        //left side = right side
        //reduce each side to ax + c format
        // we reduce the entire equation to bx = d
        //solution is x = d / b
        //both sides become 0 = infinite solution
        //if x side becomes 0 but the constant is not 0 then no solution
        //helperParse(String polynomial) : parse each side of the equation
        if(equation == null || equation.trim().length() == 0)
        {
            return "No Solution";
        }
        String[] split = equation.split("=");
        int[] left = helperParse(split[0]);
        int[] right = helperParse(split[1]);
        
        int coeffX = left[0] - right[0];
        int constant = right[1] - left[1];
        
        if(coeffX == 0 && constant == 0)
        {
            return "Infinite solutions";
        }
        else if(coeffX == 0)
        {
            return "No Solution";
        }
        StringBuilder sb = new StringBuilder();
        constant = constant / coeffX;
        sb.append("x=");
        sb.append(Integer.toString(constant));
        
        return sb.toString();
    }
    public int[] helperParse(String poly)
    {
        //0 : coeff of x, 1: constants
        int[] result = new int[2];
        int pivot = 0;
        for (int i = 0; i < poly.length(); i++)
        {
            if(poly.charAt(i) == '-' || poly.charAt(i) == '+' || i == poly.length() - 1)
            {
                String sub = poly.substring(pivot, i);
                if(i == poly.length() - 1)
                {
                    sub = poly.substring(pivot);
                }
                if(!sub.equals(""))
                {
                    int num = 0;
                    try
                    {
                        num = Integer.parseInt(sub);
                        result[1] += num;
                    }
                    catch(Exception ex)
                    {
                        sub = sub.substring(0, sub.length() - 1);
                        if(sub.equals("-") || sub.equals("+") || sub.equals(""))
                        {
                            if(sub.equals("-"))
                                num = -1;
                            else
                                num = 1;
                        }
                        else
                            num = Integer.parseInt(sub);
                        result[0] += num;
                    }
                }
                pivot = i;
            }
        }
        
        return result;
    }
}
