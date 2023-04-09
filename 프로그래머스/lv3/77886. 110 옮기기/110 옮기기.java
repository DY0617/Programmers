import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++)
        {
            int index = 0;
            String temp = s[i];
            int count = 0;
            int sp = 0;
            char[] stack = new char[temp.length()];
            while(true)
            {
                if(sp >= 3)
                {
                    int end = sp-1;
                    if(stack[end] == '0'&&stack[end-1] == '1'&&stack[end-2] == '1')
                    {
                        sp -=3;
                        count++;
                    }
                    else if(index >= temp.length()) break;
                    else stack[sp++]=temp.charAt(index++);
                }
                else if(index >= temp.length()) break;
                else stack[sp++]=temp.charAt(index++);
            }
            temp = new String(stack).substring(0, sp);

            //System.out.println(temp + " " + count);
            StringBuilder appended = new StringBuilder();
            for(int j=0; j<count; j++)
                appended.append("110");
            if(temp.length() == 0)
            {
                answer[i] = appended.toString();
            }

            int point = -1;
            for(int j=0; j<temp.length()-1; j++)
            {
                if(temp.charAt(j)=='1' && temp.charAt(j+1)=='1')
                {
                    point = j;
                    break;
                }
            }
            if(point == -1)
            {
                point = 0;
                for(int j=0; j<temp.length(); j++)
                    if(temp.charAt(j)=='0')
                        point = j+1;
            }



            //System.out.println(point);  

            temp  = point == temp.length() ? temp + appended : temp.substring(0, point) + appended + temp.substring(point);
            answer[i] = temp;

        }
        
        return answer;
    }
}