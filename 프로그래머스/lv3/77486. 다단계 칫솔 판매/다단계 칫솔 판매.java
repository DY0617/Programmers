import java.util.*;

class Solution {
    
    class Member{
        int money;
        String name;
        Member(int a,String b){
            money=a;
            name=b;
        }
        void plusMoney(int a){
            money+=a;
        }
    }
    
    
    Map<String,String> nameList=new HashMap<>();
    Map<String,Integer> list=new HashMap<>();

    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        
        for(int i=0;i<enroll.length;i++){
            list.put(enroll[i],0);
        }
        
        list.put("-",0);
        
        for(int i=0;i<referral.length;i++){
            nameList.put(enroll[i],referral[i]);
        }
        
        
        for(int i=0;i<seller.length;i++){
            String sellerName=seller[i];
            int sellAmount=amount[i]*100;
            
            Queue<String> q=new LinkedList<>();
            q.add(sellerName);
            
            while(!q.isEmpty()){
                int idx=-1;
                String name=q.poll();
                if(1>sellAmount/10){

                    list.put(name,sellAmount+list.getOrDefault(name,0));
                    
                    break;
                }
                else{
                    int upMoney=sellAmount/10;
                    int myMoney=sellAmount-upMoney;
                    


                        list.put(name,myMoney+list.getOrDefault(name,0));
                        sellAmount=upMoney;
                        String str=nameList.get(name);
                        if(!str.equals("-")&&sellAmount>0){
                            q.add(str);
                        }

                    
                }
                    
                    
                

            }
            
        }
        
        
        for(int i=0;i<list.size()-1;i++){
            answer[i]=list.get(enroll[i]);
        }
        
        return answer;
    }
}