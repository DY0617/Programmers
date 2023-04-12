class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            boolean isTrue=true;
            String nowTree=skill_trees[i];
            for(int j=0;j<skill.length()-1;j++){
                char post=skill.charAt(j);
                char pre=skill.charAt(j+1);
                int postIdx=nowTree.indexOf(post);
                int preIdx=nowTree.indexOf(pre);
                
                System.out.println(i+"   "+postIdx+"   "+preIdx);
                
                if(postIdx==-1&&preIdx!=-1){
                    isTrue=false;
                    break;
                }if(preIdx!=-1){
                    if(postIdx>preIdx){
                        isTrue=false;
                        break;
                    }   
                }
            }
            
            if(isTrue){
                answer++;
                //System.out.println(nowTree);
            }
                
        }
        
        return answer;
    }
}