import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        class Truck{
            int loc,weight;
            Truck(int a, int b){
                loc=a;
                weight=b;
            }
        }
        
        Queue<Truck> q=new LinkedList<>();
        
        int i=0;
        int nowW=0;
        
        while(truck_weights.length>i){
            

            if(q.size()<bridge_length){                
                if(q.isEmpty()){                   
                    q.add(new Truck(0,truck_weights[i]));
                    nowW+=truck_weights[i];
                    i++;
                }
                else{
                    if(nowW+truck_weights[i]<=weight){
                        nowW+=truck_weights[i];
                        q.add(new Truck(0,truck_weights[i]));
                        i++;
                    }
                }               
            }
            
            
            for(int j=0;j<q.size();j++){
                            Truck now=q.poll();
                            now.loc++;
                            q.add(now);
                        }
            
            Truck front=q.peek();
            if(front.loc==bridge_length){
                
                q.poll();
                nowW-=front.weight;
            }
            
            
            answer++;
        }
        
        while(!q.isEmpty()){
            for(int j=0;j<q.size();j++){
                Truck now=q.poll();
                now.loc++;
                q.add(now);
            }
            
            Truck front=q.peek();
            if(front.loc==bridge_length){
                
                q.poll();
                nowW-=front.weight;
            }
            
            
            answer++;
        }
        
        return answer;
    }
}