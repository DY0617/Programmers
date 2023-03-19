import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {

        m = trimNotes(m);
        int min = Integer.MIN_VALUE;
        String ans = "(None)";
        for(String infos : musicinfos){
            String[] info = infos.split(",");
            int time = (Integer.valueOf(info[1].substring(0,2)) * 60 +  // 시간 구하기
                        Integer.valueOf(info[1].substring(3,5))) -
                        (Integer.valueOf(info[0].substring(0,2)) * 60 +
                        Integer.valueOf(info[0].substring(3,5)));        

            String noteTemp = trimNotes(info[3]);  // #이 붙은 음을 lowerCase로 바꿔줌

            StringBuilder sb = new StringBuilder(); // note 를 시간 길이만큼 늘려줌
            for(int i = 0 ; i < time/noteTemp.length(); i ++) sb.append(noteTemp);
            for(int i = 0 ; i < time%noteTemp.length(); i++) 
                    sb.append(noteTemp.charAt(i));

            if(sb.toString().contains(m) && time > min){
                ans = info[2];
                min = time;
            } 
        }


        return ans;
    }



    public String trimNotes(String s){ // 뒤에 #이 있다면 lowercase로 바꿔주는 메서드
        StringBuilder note = new StringBuilder(s);
        for(int i = note.length() - 2; i >= 0 ; i --){
            if(note.charAt(i + 1) != '#')continue;
            note.deleteCharAt(i + 1);    
            note.setCharAt(i, Character.toLowerCase(note.charAt(i))); 
        }

        return note.toString();
    }

}