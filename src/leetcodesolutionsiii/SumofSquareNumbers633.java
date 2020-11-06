/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutionsiii;

/**
 *
 * @author aditp
 */
public class SumofSquareNumbers633
{
    public boolean judgeSquareSum(int c) 
    {
        int left = 0;
        int right = (int) Math.sqrt(c);
        
        while(left <= right)
        {
            int sum = left * left + right + right;
            if(sum < c)
            {
                left++;
            }
            else if(sum > c)
            {
                right--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
