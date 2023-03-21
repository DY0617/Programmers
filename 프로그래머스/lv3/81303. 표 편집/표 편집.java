import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        class node{
            int post,pre,now;
            node(int a,int b,int c){
                post=a;
                pre=b;
                now=c;
            }
        }
        
        Stack<Integer> stack=new Stack<>();
        ArrayList<node> list=new ArrayList<>();
        StringTokenizer st;
        
        
        for(int i=0; i<=n-2; i++)
            list.add(new node(i-1, i+1, 1));
        list.add(new node(n-2, -1, 1));
        
        for(String str:cmd){
            if(str.charAt(0)=='U'){
                st=new StringTokenizer(str,"U ");
                int up=Integer.parseInt(st.nextToken());
                while(up-->0)
                    k=list.get(k).post;
            }
            else if(str.charAt(0)=='D'){
                st=new StringTokenizer(str,"D ");
                int down=Integer.parseInt(st.nextToken());
                while(down-->0)
                    k=list.get(k).pre;
            }
            else if(str.charAt(0)=='C'){
                list.get(k).now=0;
                stack.push(k);
                if (list.get(k).post != -1) list.get(list.get(k).post).pre = list.get(k).pre;
                if (list.get(k).pre != -1) list.get(list.get(k).pre).post = list.get(k).post;

                k = (list.get(k).pre == -1 ? list.get(k).post : list.get(k).pre); // 마지막 셀이면 그 전으로, 아니면 그 후로
            }
            else{
                int z=stack.pop();
                list.get(z).now=1;
                if (list.get(z).post != -1)
                        list.get(list.get(z).post).pre = z;
                    if (list.get(z).pre != -1)
                        list.get(list.get(z).pre).post = z;
            }

        }
        
        
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            //System.out.println(list.get(i).post+"  "+list.get(i).now+"  "+list.get(i).pre+"  ");
            if(list.get(i).now==1)
                sb.append("O");
            else
                sb.append("X");
        }
        
        return sb.toString();
    }
}