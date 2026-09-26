package programmers.level1;

public class Solution12930 {
    public String solution(String s) {
        String[] splited = s.split(" ", -1); // 맨 뒤 빈 문자열 제거 하지 않음
        for(int i = 0 ; i < splited.length ; i++){
            String sp = splited[i];
            char[] chars = sp.toCharArray();
            for(int j = 0 ; j < chars.length ; j++){
                if(j%2 == 0){
                    chars[j] = Character.toUpperCase(chars[j]);
                }else{
                    chars[j] = Character.toLowerCase(chars[j]);
                }
            }
            splited[i] = new String(chars);
        }

        return String.join(" ",splited);
    }
}
