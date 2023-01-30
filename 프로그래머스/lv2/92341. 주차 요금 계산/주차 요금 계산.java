import java.util.*;

class Solution {
    
    static final int end=23*60+59;
    static ArrayList<String> nameList=new ArrayList<>();
    
    public int[] solution(int[] fees, String[] records) {

        
        
        Map<String,int[]> list=new HashMap<>();
        StringTokenizer st;
        
        
        for(String command:records){
            st=new StringTokenizer(command);
            String time=st.nextToken();
            String ident=st.nextToken();
            String inOut=st.nextToken();
            
            st=new StringTokenizer(time,":");
            int clock=Integer.parseInt(st.nextToken());
            int minute=Integer.parseInt(st.nextToken());
            
            int nowTime=clock*60+minute;
            
            
 
            
            if(inOut.equals("IN")){
                if(!list.containsKey(ident)){
                    int[] arr={nowTime,-1,0};
                    list.put(ident,arr);
                    nameList.add(ident);
                }
                else{
                    int[] arr=list.get(ident);
                    arr[0]=nowTime;
                    list.replace(ident,arr);
                }
            }
            else{
                int[] arr=list.get(ident);
                arr[1]=nowTime;
                int spend=arr[1]-arr[0];
                arr[2]+=spend;
                arr[0]=-1;
                arr[1]=-1;
                list.replace(ident,arr);
            }
        }
        
        Collections.sort(nameList);
        int[] answer = new int[nameList.size()];
        
        for(int i=0;i<nameList.size();i++){
            int[] arr=list.get(nameList.get(i));
            if(arr[0]!=-1&&arr[1]==-1){
                arr[1]=end;
                arr[2]+=arr[1]-arr[0];
            }

            
            double cost=arr[2];
            cost=cost-fees[0];
            if(cost<=0){
                answer[i]=fees[1];
            }
            else{

                cost=Math.ceil(cost/fees[2]);
                cost=cost*fees[3];
                answer[i]=(int)cost+fees[1];
            }
        }
        
        
        
        return answer;
    }
}