import java.util.*;

class Solution {
    
    ArrayList<String> list=new ArrayList<>();
    ArrayList<String> usingOp=new ArrayList<>();
    long answer;
    
    public long solution(String expression) {
        answer = 0;
        String[] op={"*","+","-"};
        
        for(String now:op){
            if(expression.contains(now))
                usingOp.add(now);
        }
        dfs("");
        StringTokenizer st=new StringTokenizer(expression,"*+-",true);
        
        ArrayList<String> exp=new ArrayList<>();
        
        while(st.hasMoreTokens()){
            exp.add(st.nextToken());
        }
        
        for(int i=0;i<list.size();i++){
            calculate(list.get(i),exp);
        }
        
        return answer;
    }
    
    public void dfs(String now){
        
        if(now.length()==usingOp.size()){
            list.add(now);
            return;
        }
        
        for(String op:usingOp){
            if(!now.contains(op)){
                String str=now+op;
                dfs(str);
            }
        }
        return;
    }
    
    public void calculate(String op,ArrayList<String> exp){
        ArrayList<String> expression=new ArrayList<>();
        
        for(int i=0;i<exp.size();i++)
            expression.add(exp.get(i));
        
        for(int i=0;i<op.length();i++){

            
            String nowOp=String.valueOf(op.charAt(i));
            for(int j=1;j<expression.size();j=j+2){
                if(expression.get(j).equals(nowOp)){
                    expression.remove(j);
                    String e1=expression.remove(j-1);
                    String e2=expression.remove(j-1);
                    long now;
                    if(nowOp.equals("*")){
                        now=Long.parseLong(e1)*Long.parseLong(e2);
                        expression.add(j-1,String.valueOf(now));
                    }
                    else if(nowOp.equals("-")){
                        now=Long.parseLong(e1)-Long.parseLong(e2);
                        expression.add(j-1,String.valueOf(now));
                    }
                    else{
                        now=Long.parseLong(e1)+Long.parseLong(e2);
                        expression.add(j-1,String.valueOf(now));
                    }
                    j=j-2;
                }
            }
            
        }
        
        long longEx=Math.abs(Long.parseLong(expression.get(0)));
        
        answer=Math.max(answer,longEx);
        
        return;
    }
}