package leetcodesolutionsiii;



public class AdditiveNumber306
{
    public boolean isAdditiveNumber(String num)
    {
        if(num.length() <= 1)
        {
            return false;
        }
        if(num.charAt(0) == '0' && num.charAt(1) == '0' && Integer.parseInt(num) == 0)
        {
            return true;
        }
        else if(num.charAt(0) == '0' && num.charAt(1) == '0' && Integer.parseInt(num) != 0)
        {
            return false;
        }
        int fnSize = 1;
        int snSize = 1;
        while(fnSize < num.length())
        {
            String strFn = num.substring(0, fnSize);
            long fn = Long.parseLong(strFn);
            if(fn > Integer.MAX_VALUE)
            {
                break;
            }
            while(fnSize + snSize <= num.length())
            {
                String strSn = num.substring(fnSize, fnSize + snSize);
                if(strSn.length() > 1 && strSn.charAt(0) == '0')
                {
                    break;
                }
                long sn = Long.parseLong(strSn);
                if(sn > Integer.MAX_VALUE)
                {
                    break;
                }
                long res = fn + sn;
                if(res > Integer.MAX_VALUE)
                {
                    break;
                }
                String strRes = Long.toString(res);
                if(strRes.length() <= num.length() - fnSize - snSize)
                {
                    String strCand = num.substring(fnSize + snSize, fnSize + snSize + strRes.length());
                    int cand = Integer.parseInt(strCand);
                    if(cand == res)
                    {
                        if(validateAdditive(num, sn, res, fnSize + snSize + strRes.length()))
                        {
                            return true;
                        }
                    }
                }
                snSize++;
            }
            snSize = 1;
            if(fn == 0)
            {
                return false;
            }
            fnSize++;
        }
        return false;
    }
    
    private boolean validateAdditive(String num, long first, long sec, int pos)
    {
        
        if(pos == num.length())
        {
            return true;
        }
        long res = first + sec;
        if(res > Integer.MAX_VALUE)
        {
            return false;
        }
        String strRes = Long.toString(res);
        if(pos + strRes.length() > num.length())
        {
            return false;
        }
        String strCand = num.substring(pos, pos + strRes.length());
        long cand = Long.parseLong(strCand);
        if(cand == res)
        {
            return validateAdditive(num, sec, res, pos + strRes.length());
        }
        else
        {
            return false;
        }
        //return false;
    }
}
