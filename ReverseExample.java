import java.lang.*;
class ReverseExample
{
    public static void main(String args[])
    {
        String s = args[0];
        StringBuffer st = new StringBuffer(s);
        StringBuffer rev = st.reverse().append(" ");
        int i=0;
        StringBuffer word = new StringBuffer();
        char tmp = ' ';
        StringBuffer res = new StringBuffer();
        while(i < rev.length())
        {
            tmp = rev.charAt(i);
            if(tmp!=' ')
            {
                word.append(tmp);
                i++;
            }
            else
            {
                res.append(word.reverse()).append(" ");
                word = new StringBuffer();
                i++;
            }
        }
        System.out.println(res);
    }
}