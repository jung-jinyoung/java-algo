package programmers.level1;

import java.util.Map;
import java.util.HashMap;

public class Solution81301 {
    public int solution(String s) {
        String answer = "";
        String[] arr = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        Map<String, Integer> map = new HashMap<>();

        // 인덱스를 활용하여 문자열 -> 숫자 변환
        for (int i = 0 ; i < 10 ; i++){
            map.put(arr[i], i);
        }

        String letter = "";

        // 향상된 for문 사용을 위한 문자열 -> 문자리스트로 변환
        for(char c : s.toCharArray()){
            // 현재 위치에 숫자가 있으면
            if(Character.isDigit(c)){
                // 현재 만들어진 문자열 확인
                if (letter != ""){
                    answer += map.get(letter);
                    letter = "";
                }
                // 해당값도 추가
                answer += c;
            } else {
                // 현재까지 완성된 문자열 확인
                if(map.containsKey(letter)){
                    answer += map.get(letter);
                    letter = "";
                }
                letter += c;
            }
        }
        // 모든 순회 후 한번 더 문자열 확인
        if(map.containsKey(letter)){
            answer += map.get(letter);
        }
        return Integer.parseInt(answer);
    }
}
