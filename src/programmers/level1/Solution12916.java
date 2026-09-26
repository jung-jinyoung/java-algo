package programmers.level1;

public class Solution12916 {
    boolean solution(String s) {
        int pCnt = 0 ;
        int yCnt = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == 'p' || c == 'P'){
                pCnt++;
            }
            if(c == 'y' || c == 'Y'){
                yCnt++;
            }
        }
        if (pCnt == yCnt ){
            return true;
        }
        return false;
    }
}
