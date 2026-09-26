package programmers.level0;

public class Solution181874 {
    public String solution(String myString) {
        char[] chars = myString.toCharArray();
        for (int i = 0 ; i < chars.length ; i++){
            char c = chars[i];
            if (!Character.isLetter(c)){
                continue;
            }
            if (c == 'a') {
                chars[i] = 'A';
                continue;
            }
            if (c != 'A' && Character.isUpperCase(c)){
                chars[i] = Character.toLowerCase(c);
            }
        }
        return new String(chars);
    }
}
